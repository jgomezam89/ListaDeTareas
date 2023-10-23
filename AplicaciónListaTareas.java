import java.util.ArrayList;
import java.util.Scanner;

public class ListaTareas {

    private ArrayList<String> tareas;
    private ArrayList<Boolean> completadas;

    public ListaTareas() {
        tareas = new ArrayList<>();
        completadas = new ArrayList<>();
    }

    public void agregarTarea(String tarea) {
        tareas.add(tarea);
        completadas.add(false);
        System.out.println("Tarea agregada: " + tarea);
    }

    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
            completadas.remove(indice);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }

    public void marcarTareaCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            completadas.set(indice, true);
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }

    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
        } else {
            System.out.println("Tareas:");
            for (int i = 0; i < tareas.size(); i++) {
                String tarea = tareas.get(i);
                boolean completada = completadas.get(i);
                String estado = completada ? "[X]" : "[ ]";
                System.out.println(estado + " " + (i + 1) + ". " + tarea);
            }
        }
    }

    public static void main(String[] args) {
        ListaTareas lista = new ListaTareas();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("---- Lista de Tareas ----");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la tarea: ");
                    String tarea = scanner.nextLine();
                    lista.agregarTarea(tarea);
                    break;
                case "2":
                    lista.mostrarTareas();
                    break;
                case "3":
                    System.out.print("Ingrese el número de tarea a marcar como completada: ");
                    int indiceCompletada = Integer.parseInt(scanner.nextLine());
                    lista.marcarTareaCompletada(indiceCompletada - 1);
                    break;
                case "4":
                    System.out.print("Ingrese el número de tarea a eliminar: ");
                    int indiceEliminar = Integer.parseInt(scanner.nextLine());
                    lista.eliminarTarea(indiceEliminar - 1);
                    break;
                case "5":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

            System.out.println();
        } while (!opcion.equals("5"));

        scanner.close();
    }
}

