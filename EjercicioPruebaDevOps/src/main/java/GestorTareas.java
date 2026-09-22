/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */
public class GestorTareas {

    ArrayList<String> listadoTareas = new ArrayList<>();
    ArrayList<String> TareasCompletadas = new ArrayList<>();

    public boolean registrarTarea(String tarea) {

        if (listadoTareas.add(tarea)) {
            return true;
        }

        return false;

    }

    public boolean completarTarea(String tarea) {

        if (TareasCompletadas.add(tarea)) {

            
            for (String listadoTarea : listadoTareas) {
                
                if (listadoTarea.toString().equals(tarea)){
                    
                    listadoTareas.remove(listadoTarea);
                    
                }
                
            }
            
            return true;

        }

        return false;
    }

    public String listarTareas() {

        if (!listadoTareas.isEmpty()) {

            for (String listadoTarea : listadoTareas) {
                System.out.println("Lista de tareas no completadas:");
                System.out.println(listadoTarea.toString());

            }
            
            for (String TareasCompletada : TareasCompletadas) {
                System.out.println("Lista de tareas completadas");
                System.out.println(TareasCompletada.toString());
                
            }

        }
        return "No hay tareas en la lista";

    }

    public boolean eliminarTarea(String tarea) {

        if (!listadoTareas.isEmpty()) {
            for (String listadoTarea : listadoTareas) {

                if (tarea.equals(listadoTarea.toString())) {

                    listadoTareas.remove(listadoTarea);

                }

            }
            
            for (String TareasCompletada : TareasCompletadas) {
                
                if (tarea.equals(TareasCompletadas.toString())){
                    
                    TareasCompletadas.remove(TareasCompletada);
               
                }
                
            }

            return true;
            
        }
        return false;
    }

}
