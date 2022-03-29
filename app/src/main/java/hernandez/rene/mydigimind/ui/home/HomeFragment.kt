package hernandez.rene.mydigimind.ui.home

import Task
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hernandez.rene.mydigimind.databinding.FragmentHomeBinding
import android.widget.BaseAdapter as BaseAdapter
import hernandez.rene.mydigimind.R
import hernandez.rene.mydigimind.adaptadorTareas
import hernandez.rene.mydigimind.ui.Recordatorio

class HomeFragment : Fragment() {
    var tasks: ArrayList<Task> = ArrayList<Task>()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val gridView: GridView = binding.gridView

        fillTasks()
        val adaptador = adaptadorTareas(root.context, tasks)
        gridView.adapter = adaptador
        return root
    }

    fun fillTasks() {


        tasks.add(Task("Practice 1","Tuesday","17:30"))
        tasks.add(Task("Practice 2","Monday, Saturday","17:00"))
        tasks.add(Task("Practice 3","Wednesday","14:00"))
        tasks.add(Task("Practice 4","Saturday","11:00"))
        tasks.add(Task("Practice 5","Friday","13:00"))
        tasks.add(Task("Practice 6","Thursday","10:40"))
        tasks.add(Task("Practice 7","Monday","12:00"))

    }
}

    class Adapter() : BaseAdapter() {
        var rec = ArrayList<Recordatorio>()
        var context: Context? = null

        constructor(context: Context?, rec: ArrayList<Recordatorio>) : this() {
            this.rec = rec
            this.context = context
        }

        override fun getCount(): Int {
            return rec.size
        }

        override fun getItem(position: Int): Any {
            return rec[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var aux = rec[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflater.inflate(R.layout.recordatorio, null)

            var nombre: TextView =  vista.findViewById(R.id.textNombreRecordatorio)
            var dias:   TextView =  vista.findViewById(R.id.textDiasRecordatorio)
            var tiempo: TextView =  vista.findViewById(R.id.textTiempoRecordatorio)

            nombre.setText(aux.nombre)
            dias.setText(aux.dias)
            tiempo.setText(aux.tiempo)

            return vista
        }

    }