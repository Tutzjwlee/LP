package Aula_24;

import java.util.ArrayList;
import java.util.List;

public class TarefaController {
    private List<TarefaModel> tarefas = new ArrayList<>();
    private TarefaView view = new TarefaView();

    public void adicionarTarefa(String descricao){
        TarefaModel novaTarefa = new TarefaModel(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(int indice){
        tarefas.remove(indice);
    }

    public void marcarTarefaComoConcluida(int indice){
        if(indice >= 0 && indice< tarefas.size()){
            tarefas.get(indice).marcarComoConcluida();
        }
    }

    public void marcarTarefaComoNaoConcluida(int indice){
        if(indice >= 0 && indice< tarefas.size()){
            tarefas.get(indice).marcarComoNaoConcluida();
        }
    }

    public void atualizarView(){
        view.exibirTarefas(tarefas);
    }

    public String atualizarView2(){
        return view.retornarTarefas(tarefas);
    }

}
