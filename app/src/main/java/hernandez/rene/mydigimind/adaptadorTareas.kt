package hernandez.rene.mydigimind

import Task
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.security.AccessControlContext

class adaptadorTareas: BaseAdapter {
    lateinit var context: Context
    var tasks: ArrayList<Task> = ArrayList<Task>()

    constructor(contexto: Context, tasks: ArrayList<Task>){
        this.context = contexto
        this.tasks = tasks
    }

    override fun getCount(): Int {
        return tasks.size
    }

    override fun getItem(p0: Int): Any {
        return tasks[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.task_view, null)

        var task = tasks[p0]

        val tv_titulo: TextView = vista.findViewById(R.id.taskName)
        val tv_time: TextView = vista.findViewById(R.id.taskTime)
        val tv_dia: TextView = vista.findViewById(R.id.taskWhen)

        tv_titulo.setText(task.title)
        tv_dia.setText(task.days)
        tv_time.setText(task.time)

        return vista
    }

}