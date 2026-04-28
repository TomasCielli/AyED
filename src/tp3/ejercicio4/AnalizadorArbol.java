package tp3.ejercicio4;

import java.util.Iterator;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class AnalizadorArbol {

	public class AreaEmpresa {
		String id;
		int tardanza;
		
		public AreaEmpresa(String id, int tardanza) {
			this.id = id;
			this.tardanza = tardanza;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getTardanza() {
			return tardanza;
		}

		public void setTardanza(int tardanza) {
			this.tardanza = tardanza;
		}
		
		
	}
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		double maximo = -1;
		if (!arbol.isEmpty()) {
			Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
			cola.enqueue(arbol); cola.enqueue(null);
			double demora_total = 0, demora_promedio= 0; int cant = 0;
			while (!cola.isEmpty()) {
				GeneralTree<AreaEmpresa> nodo = cola.dequeue();
				if (nodo != null) {
					if (nodo.hasChildren()) {
						Iterator<GeneralTree<AreaEmpresa>> it = nodo.getChildren().iterator();
						while (it.hasNext()) cola.enqueue(it.next());
					}
					cant++;
					demora_total += nodo.getData().getTardanza();
				}
				else {
					demora_promedio = demora_total / cant;
					maximo = demora_promedio > maximo? demora_promedio: maximo;
					demora_total = 0; cant = 0;
					if (!cola.isEmpty()) {
						cola.enqueue(null);
					}
				}
			}
		}
		return maximo;
	}
	
}
