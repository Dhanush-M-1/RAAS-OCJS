#include<bits/stdc++.h>
typedef long long int ll;
typedef unsigned long long int ull;
#define BIG_NUM 2000000000
#define HUGE_NUM 99999999999999999
#define MOD 1000000007
#define EPS 0.000000001
using namespace std;


#define NUM 100005

struct GROUP{
	vector<int> nodes;
};

struct Edge{
	Edge(int arg_to,bool arg_is_directed){
		to = arg_to;
		is_directed = arg_is_directed;
	}
	int to;
	bool is_directed;
};

struct Info{
	Info(int arg_node_id,int arg_adj_node){
		node_id = arg_node_id;
		adj_node = arg_adj_node;
	}
	int node_id,adj_node;
};

struct Data{
	Data(){
		node_id = 0;
		sum_cost = 0;
	}
	Data(int arg_node_id,ll arg_sum_cost){
		node_id = arg_node_id;
		sum_cost = arg_sum_cost;
	}
	bool operator<(const struct Data &arg) const{
		return sum_cost < arg.sum_cost;
	}

	int node_id;
	ll sum_cost;
};

int V,E;
GROUP group[NUM];
vector<Edge> G[NUM];
vector<int> DAG_G[NUM];
vector<int> rev_G[NUM];
vector<Info> Connect[NUM];
stack<int> S;
bool check[NUM];
int table[NUM],in_num[NUM];
int group_index;
ll max_node_cost[NUM],in_max[NUM];


void dfs(int node_id){
	check[node_id] = true;

	for(int i = 0; i < G[node_id].size(); i++){
		if(!check[G[node_id][i].to])dfs(G[node_id][i].to);
	}
	S.push(node_id);
}

void reverse_dfs(int node_id){
	check[node_id] = true;

	group[group_index].nodes.push_back(node_id);
	table[node_id] = group_index;

	for(int i = 0; i < rev_G[node_id].size(); i++){
		if(!check[rev_G[node_id][i]])reverse_dfs(rev_G[node_id][i]);
	}
}

ll dfs_first(int group_id,int node_id,int parent){

	ll ret = in_max[node_id];

	for(int i = 0; i < G[node_id].size(); i++){
		if(table[G[node_id][i].to] != group_id || G[node_id][i].to == parent)continue;

		ret = max(ret,dfs_first(group_id,G[node_id][i].to,node_id)+1);
	}
	return max_node_cost[node_id] = ret;
}

void dfs_to_descendant(int group_id,int node_id,int parent,ll sum_cost){

	max_node_cost[node_id] = max(max_node_cost[node_id],sum_cost);

	ll tmp_cost;
	priority_queue<Data> Q;

	for(int i = 0; i < G[node_id].size(); i++){

		if(table[G[node_id][i].to] != group_id || G[node_id][i].to == parent)continue;

		Q.push(Data(G[node_id][i].to,max_node_cost[G[node_id][i].to]+1));
	}

	if(Q.size() == 0){

		tmp_cost = max(sum_cost,in_max[node_id])+1;

		for(int i = 0; i < G[node_id].size(); i++){
			if(table[G[node_id][i].to] != group_id || G[node_id][i].to == parent)continue;
			dfs_to_descendant(group_id,G[node_id][i].to,node_id,tmp_cost);
		}

	}else if(Q.size() == 1){

		Data data1 = Q.top();

		tmp_cost = max(sum_cost,in_max[node_id])+1;

		for(int i = 0; i < G[node_id].size(); i++){

			if(table[G[node_id][i].to] != group_id || G[node_id][i].to == parent)continue;

			if(G[node_id][i].to == data1.node_id){

				dfs_to_descendant(group_id,G[node_id][i].to,node_id,tmp_cost);

			}else{

				dfs_to_descendant(group_id,G[node_id][i].to,node_id,max(tmp_cost,data1.sum_cost+1));
			}
		}

	}else{

		tmp_cost = max(sum_cost,in_max[node_id])+1;

		Data data1 = Q.top();
		Q.pop();
		Data data2 = Q.top();
		Q.pop();

		for(int i = 0; i < G[node_id].size(); i++){

			if(table[G[node_id][i].to] != group_id || G[node_id][i].to == parent)continue;

			if(G[node_id][i].to == data1.node_id){

				dfs_to_descendant(group_id,G[node_id][i].to,node_id,max(tmp_cost,data2.sum_cost+1));

			}else{

				dfs_to_descendant(group_id,G[node_id][i].to,node_id,max(tmp_cost,data1.sum_cost+1));
			}

		}
	}
}

void calc_cost(int group_id){

	int tmp_node,adj_node;
	for(int i = 0; i < Connect[group_id].size(); i++){

		tmp_node = Connect[group_id][i].node_id;
		adj_node = Connect[group_id][i].adj_node;

		in_max[tmp_node] = max(in_max[tmp_node],max_node_cost[adj_node]+1);
	}

	dfs_first(group_id,group[group_id].nodes[0],-1);

	dfs_to_descendant(group_id,group[group_id].nodes[0],-1,0);
}

int main(){

	scanf("%d %d",&V,&E);
	int from,to,command;

	for(int loop = 0; loop < E; loop++){

		scanf("%d %d %d",&from,&to,&command);
		from--;
		to--;
		if(command == 1){

			G[from].push_back(Edge(to,true));
			rev_G[to].push_back(from);

		}else{

			G[from].push_back(Edge(to,false));
			G[to].push_back(Edge(from,false));
			rev_G[from].push_back(to);
			rev_G[to].push_back(from);
		}
	}

	for(int i = 0; i < V; i++)check[i] = false;

	for(int i = 0; i < V; i++){
		if(!check[i]){
			dfs(i);
		}
	}

	for(int i = 0; i < V; i++)check[i] = false;

	group_index = 0;
	while(!S.empty()){
		if(!check[S.top()]){
			reverse_dfs(S.top());
			group_index++;
		}
		S.pop();
	}

	int node_num,edge_num;
	int tmp_node,next_group;

	for(int i = 0; i < group_index; i++){

		node_num = (int)group[i].nodes.size();
		edge_num = 0;

		for(int k = 0; k < group[i].nodes.size(); k++){

			tmp_node = group[i].nodes[k];

			for(int p = 0; p < G[tmp_node].size(); p++){

				next_group = table[G[tmp_node][p].to];
				if(next_group == i){

					if(G[tmp_node][p].is_directed){
						printf("Infinite\n");
						return 0;
					}
					edge_num++;

				}else{
					DAG_G[i].push_back(next_group);
				}
			}
		}

		edge_num /= 2;

		if(edge_num >= node_num){
			printf("Infinite\n");
			return 0;
		}

		for(int k = 0; k < group[i].nodes.size(); k++){

			tmp_node = group[i].nodes[k];

			for(int p = 0; p < rev_G[tmp_node].size(); p++){

				next_group = table[rev_G[tmp_node][p]];
				if(next_group == i){
					//Do nothing
				}else{
					Connect[i].push_back(Info(tmp_node,rev_G[tmp_node][p]));
				}
			}
		}
	}

	for(int i = 0; i < group_index; i++)in_num[i] = 0;

	for(int i = 0; i < group_index; i++){
		sort(DAG_G[i].begin(),DAG_G[i].end());
		DAG_G[i].erase(unique(DAG_G[i].begin(),DAG_G[i].end()),DAG_G[i].end());
		for(int k = 0; k < DAG_G[i].size(); k++){
			in_num[DAG_G[i][k]]++;
		}
	}

	for(int i = 0; i < V; i++){
		max_node_cost[i] = 0;
		in_max[i] = 0;
	}

	queue<int> Q;

	for(int i = 0; i < group_index; i++){
		if(in_num[i] == 0){
			Q.push(i);
		}
	}

	int tmp_group;

	while(!Q.empty()){

		tmp_group = Q.front();
		Q.pop();

		calc_cost(tmp_group);

		for(int i = 0; i < DAG_G[tmp_group].size(); i++){
			in_num[DAG_G[tmp_group][i]] -= 1;
			if(in_num[DAG_G[tmp_group][i]] == 0){
				Q.push(DAG_G[tmp_group][i]);
			}
		}
	}

	ll ans = 0;
	for(int i = 0; i < V; i++){
		ans = max(ans,max_node_cost[i]);
	}

	printf("%lld\n",ans);

	return 0;
}

