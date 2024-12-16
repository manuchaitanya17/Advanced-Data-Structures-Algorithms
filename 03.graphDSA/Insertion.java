//CHAPTER-3 GRAPH DATA STRUCTURE

//THEORY
//A. GRAPH- INTRODUCTION- RN
//B. GRAPH TERMINOLOGY- RN
//C. REPRESENTATION OF GRAPH DATA STRUCTURES- RN
//D. TYPES OF GRAPH DATA STRUCTURE- RN

package com.company.Graphs;

import com.company.Arraylist;

import java.util.ArrayList;

//E. IMPLEMENTATION OF GRAPH
public class Insertion {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight= w;
        }

    }
    public static void createGraph1(ArrayList<Edge> graph[]){
        for(int i=0; i< graph.length; i++){
            //Creation of Nodes/Vertex of Graph as ArrayList Object:
            graph[i] = new ArrayList<>();
            //[{}, {}, {}, {}]
        }
        //Creation of Edges Object of individual Nodes:
        graph[0].add(new Edge(1,2)); //[{(s->1, d->2)}, {}, {}, {}]
        graph[1].add(new Edge(1,2)); //[{(s->1, d->2)}, {(s->1, d->2)}, {}, {}]
        graph[1].add(new Edge(1,3)); //[{(s->1, d->2)}, {(s->1, d->2),(s->1, d->3)}, {}, {}]
        graph[2].add(new Edge(2,0)); //[{(s->1, d->2)}, {(s->1, d->2),(s->1, d->3)}, {(s->2, d->0)}, {}]
        graph[2].add(new Edge(2,1)); //[{(s->1, d->2)}, {(s->1, d->2),(s->1, d->3)}, {(s->2, d->0),(s->2, d->1)}, {}]
        graph[2].add(new Edge(2,3)); //[{(s->1, d->2)}, {(s->1, d->2),(s->1, d->3)}, {(s->2, d->0),(s->2, d->1), (s->2, d->3)}, {}]
        graph[3].add(new Edge(3,1)); //[{(s->1, d->2)}, {(s->1, d->2),(s->1, d->3)}, {(s->2, d->0),(s->2, d->1), (s->2, d->3)}, {(s->3, d->1)}]
        graph[3].add(new Edge(3,2)); //[{(s->1, d->2)}, {(s->1, d->2),(s->1, d->3)}, {(s->2, d->0),(s->2, d->1), (s->2, d->3)}, {(s->3, d->1), (s->3, d->2)}]
    }


    public static void createGraph2(ArrayList<Edge> graph2[]){
        for(int i=0; i< graph2.length; i++){
            graph2[i] = new ArrayList<>();
        }
        graph2[0].add(new Edge(1,2,2));
        graph2[1].add(new Edge(1,2,0));
        graph2[1].add(new Edge(1,3,10));
        graph2[2].add(new Edge(2,0, 2));
        graph2[2].add(new Edge(2,1,10));
        graph2[2].add(new Edge(2,3, -1));
        graph2[3].add(new Edge(3,1,0));
        graph2[3].add(new Edge(3,2, -1));
    }
    public static void main(String[] args) {

//        FOR UNWEIGHTED-UNDIRECTED GRAPHS:
//        int V = 4;
//        ArrayList<Edge> graph[]= new ArrayList[V];
//        First Array Object has been created in the heap, running main function.
//        [null, null, null,null]

//        Printing 2's neighbour:
//        createGraph(graph);
//        for (int i = 0; i <graph[2].size() ; i++) {
//            System.out.println(graph[2].get(i).dest);
//        }



//        FOR WEIGHTED-UNDIRECTED GRAPHS:
//        int V2 = 4;
//        ArrayList<Edge> graph2[]= new ArrayList[V2];
//        createGraph2(graph2);
//        for (int i = 0; i <graph2[2].size() ; i++) {
//            System.out.println(graph2[2].get(i).dest + " " + graph2[2].get(i).weight);
//        }










    }
}
