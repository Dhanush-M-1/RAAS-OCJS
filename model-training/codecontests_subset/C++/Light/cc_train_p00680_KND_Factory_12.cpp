#include<bits/stdc++.h>
typedef long long int ll;
typedef unsigned long long int ull;
#define BIG_NUM 2000000000
#define HUGE_NUM 99999999999999999
#define MOD 1000000007
//#define EPS 0.000000001
using namespace std;


#define EPS 0.0000001

typedef vector<double> VEC;
typedef vector<VEC> MATRIX;
typedef pair<double,int> P; //firstは最短距離、secondは頂点の番号

#define NUM 105

//辺を表す構造体{行先、容量、コスト、逆辺のインデックス}
struct Edge{
	Edge(int arg_to,int arg_capacity,double arg_cost,int arg_rev_index){
		to = arg_to;
		capacity = arg_capacity;
		cost = arg_cost;
		rev_index = arg_rev_index;
	}

	int to,capacity,rev_index;
	double cost;
};

int V; //頂点数
int H,W;
vector<Edge> G[NUM]; //グラフの隣接リスト表現
double h[NUM]; //ポテンシャル
double dist[NUM]; //最短距離
int pre_node[NUM],pre_edge[NUM]; //直前の頂点と辺
int adj[NUM];


void add_edge(int from,int to,int capacity,double cost){
	G[from].push_back(Edge(to,capacity,cost,G[to].size()));
	G[to].push_back(Edge(from,0,-cost,G[from].size()-1));
}

//流せない場合は-1を返す
double min_cost_flow(int source,int sink,int flow){

	double ret = 0;
	for(int i = 0; i < V; i++)h[i] = 0;
	while(flow > 0){
		//ダイクストラ法を用いてhを更新する
		priority_queue<P,vector<P>,greater<P>> Q;
		for(int i = 0; i < V; i++)dist[i] = BIG_NUM;
		dist[source] = 0;
		Q.push(P(0,source));

		while(!Q.empty()){
			P p = Q.top();
			Q.pop();
			int node_id = p.second;
			if(dist[node_id]+0.00001 < p.first)continue; //最短でなければSKIP
			for(int i = 0; i < G[node_id].size(); i++){
				Edge &e = G[node_id][i];
				if(e.capacity > 0 && dist[e.to] > 0.00001+dist[node_id]+e.cost+h[node_id]-h[e.to]){
					dist[e.to] = dist[node_id]+e.cost+h[node_id]-h[e.to];
					pre_node[e.to] = node_id;
					pre_edge[e.to] = i;
					Q.push(P(dist[e.to],e.to));
				}
			}
		}

		if(fabs(dist[sink]-BIG_NUM) < 0.00001){
			//これ以上流せない
			return -1;
		}

		for(int node_id = 0; node_id < V; node_id++)h[node_id] += dist[node_id];

		//source-sink間最短路に沿って目いっぱい流す
		int tmp_flow = flow;
		for(int node_id = sink; node_id != source; node_id = pre_node[node_id]){
			tmp_flow = min(tmp_flow,G[pre_node[node_id]][pre_edge[node_id]].capacity);
		}
		flow -= tmp_flow;
		ret += tmp_flow*h[sink];
		for(int node_id = sink; node_id != source; node_id = pre_node[node_id]){
			Edge &e = G[pre_node[node_id]][pre_edge[node_id]];
			e.capacity -= tmp_flow;
			G[node_id][e.rev_index].capacity += tmp_flow;
		}
	}
	return ret;
}



MATRIX gauss_jordan(MATRIX A){

	MATRIX C(H,VEC(W+1));

	for(int row = 0; row < H; row++){
		for(int col = 0; col <= W; col++){
			C[row][col] = A[row][col];
		}
	}

	int base_row;
	double tmp;

	for(int i = 0; i < H; i++){
		base_row = i;
		for(int row = i+1; row < W; row++){
			if(fabs(C[row][i]) > fabs(C[base_row][i])){
				base_row = row;
			}
		}

		if(fabs(C[base_row][i]) < EPS)continue; //操作不要

		if(base_row != i)swap(C[base_row],C[i]);

		tmp = C[i][i]; //係数
		for(int col = 0; col <= W; col++){ //基準行の係数を1にする
			C[i][col] /= tmp;
		}

		for(int row = 0; row < H; row++){
			if(row == i || fabs(C[row][i]) < EPS)continue; //基準行、または該当列が0ならSKIP

			tmp = C[row][i];

			for(int col = i; col <= W; col++){
				C[row][col] -= C[i][col]*tmp;
			}
		}
	}

	return C;
}

void func(){

	for(int i = 0; i < NUM; i++){

		G[i].clear();
	}

	int source,sink,FLOW;

	scanf("%d %d %d %d",&V,&source,&sink,&FLOW);

	H = V;
	W = V;

	MATRIX A(H,VEC(W+1));

	for(int row = 0; row < H; row++){
		for(int col = 0; col <= W; col++){

			scanf("%lf",&A[row][col]);
		}
	}

	//気温を計算
	A = gauss_jordan(A);

	int num_edge,tmp_capacity;

	for(int loop = 0; loop < V; loop++){

		scanf("%d",&num_edge);
		for(int i = 0; i < num_edge; i++){

			scanf("%d",&adj[i]);
		}

		for(int i = 0; i < num_edge; i++){

			scanf("%d",&tmp_capacity);

			add_edge(loop,adj[i],tmp_capacity,fabs(A[loop][W]-A[adj[i]][W]));
		}
	}

	double ans = min_cost_flow(source,sink,FLOW);

	if(fabs(ans+1.0) < EPS){

		printf("impossible\n");

	}else{

		printf("%.10lf\n",ans);
	}
}

int main(){

	int num_case;
	scanf("%d",&num_case);

	for(int loop = 0; loop < num_case; loop++){

		func();
	}

	return 0;
}

