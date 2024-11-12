package com.example.musting.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musting.data.model.CurrencyPrice
import com.example.musting.data.model.CurrentBinance
import com.example.musting.data.api.RetrofitClient
import com.example.musting.databinding.FragmentHomeBinding
import com.example.musting.ui.model.Current
import com.example.musting.ui.adapter.CurrentsViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.round

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CurrentsViewAdapter
    private val data: MutableList<Current> = mutableListOf()

    private var isLoading = false  // Флаг для предотвращения повторных запросов
    private var currentPage = 0    // Текущая страница для пагинации
    private val pageSize = 20      // Размер страницы (количество элементов на запрос)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка адаптера для RecyclerView
        binding.currents.layoutManager = LinearLayoutManager(context)
        adapter = CurrentsViewAdapter(data)
        binding.currents.adapter = adapter

        // Добавляем слушатель для прокрутки
        binding.currents.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                // Проверяем, если доскроллили до последнего элемента и нет активной загрузки
                if (!isLoading && lastVisibleItemPosition == totalItemCount - 1) {
                    currentPage++  // Увеличиваем номер страницы
                    fetchAllSymbols()  // Загружаем следующую порцию данных
                }
            }
        })

        // Первичная загрузка данных
        fetchAllSymbols()
    }

    // Функция для получения всех символов валютных пар с суффиксом "USDT"
    private fun fetchAllSymbols() {
        isLoading = true  // Устанавливаем флаг, что идет загрузка

        RetrofitClient.instance.getAllPrices().enqueue(object : Callback<List<CurrencyPrice>> {
            override fun onResponse(
                call: Call<List<CurrencyPrice>>,
                response: Response<List<CurrencyPrice>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { prices ->
                        // Фильтруем символы, которые оканчиваются на "USDT", и берем только нужный блок данных
                        val symbols = prices
                            .map { it.symbol }
                            .filter { it.endsWith("USDT") }
                            .drop(currentPage * pageSize)
                            .take(pageSize)

                        // Для каждого символа запрашиваем его текущие данные
                        symbols.forEach { fetchCurrencyData(it) }
                    }
                }

                isLoading = false  // Сбрасываем флаг загрузки
            }

            override fun onFailure(call: Call<List<CurrencyPrice>>, t: Throwable) {
                Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
                isLoading = false  // Сбрасываем флаг загрузки в случае ошибки
            }
        })
    }

    // Функция для получения данных валютной пары по символу
    private fun fetchCurrencyData(symbol: String) {
        RetrofitClient.instance.getCurrentBySymbol24hr(symbol).enqueue(object : Callback<CurrentBinance> {
            override fun onResponse(
                call: Call<CurrentBinance>,
                response: Response<CurrentBinance>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        // Добавляем данные в список и уведомляем адаптер об изменениях
                        data.add(
                            Current(
                                shortName = it.symbol.substring(0, it.symbol.length - 4),
                                fullName = it.symbol,
                                cost = it.lastPrice.toDouble(),
                                grow = (round(it.priceChangePercent.toDouble() * 100) / 100)
                            )
                        )
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<CurrentBinance>, t: Throwable) {
                Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

