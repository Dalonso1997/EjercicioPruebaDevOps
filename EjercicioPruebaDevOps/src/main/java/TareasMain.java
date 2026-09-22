/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class TareasMain {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorTareas g = new GestorTareas();
        
        int eleccion = -1;
        
        do {
        System.out.println("Introduce que quieres hacer:");
        System.out.println("1. registrar tarea, 2. marcar una tarea como completada, "
                + "\n3. listar tareas, 4. eliminar una tarea");
        
        
        eleccion = Integer.parseInt(teclado.next());
        teclado.nextLine();
        
        switch (eleccion){
            
            
            case 1 -> {
                
                System.out.println("Introduce la tarea que quieres registrar");
                String tarea = teclado.nextLine();
                
                if (g.registrarTarea(tarea)){
                    
                    System.out.println("Tarea anadida correctamente.");
                    
                } else {
                    
                    System.out.println("La tarea no se pudo anadir");
                    
                }
                
            }
            
            case 2 ->{
                System.out.println("Lista de tareas sin completar:");
                g.listarTareas();
                System.out.println("Elige que tarea quieres completar:");
                String tareaACompletar = teclado.nextLine();
                
                if (g.completarTarea(tareaACompletar)){
                    
                    System.out.println("Tarea marcada como completada.");
                    
                }
            }
            
            case 3 ->{
                
                g.listarTareas();
                
            }
            
            case 4 ->{
                
                System.out.println("Introduce la tarea que quieres eliminar");
                String tarea = teclado.nextLine();
                
                if (g.eliminarTarea(tarea)){
                    System.out.println("Tarea eliminada correctamente");
                    g.listarTareas();
                } else {
                    System.out.println("No se ha podido eliminar la tarea.");
            
                }
                }
            
        }
        
        
    } while (eleccion != 0);
    
        }
}