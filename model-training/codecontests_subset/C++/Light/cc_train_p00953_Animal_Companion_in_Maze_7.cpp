#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;i++)
using namespace std;

typedef long long int64;
typedef pair<int,int> PII;

int n,m;

vector<PII> biEdge[123456];
vector<int> uniEdge[123456];

vector<int> nodes[123456];

struct Edge{
	int t,w;
	Edge(int t,int w):t(t),w(w){}
};

vector<Edge> edge[2345678];

//a vertex can reach all
// <- <- <- nadj
// -> -> -> nadj

void addE(int u,int v,int w){
	edge[u].push_back(Edge(v,w));
}

int findNode(int u,int id,int tp){
	int pos = lower_bound(biEdge[u].begin(),biEdge[u].end(),make_pair(id,-1)) - biEdge[u].begin();

	return nodes[u][2 + biEdge[u].size() * tp + pos];
}

int indeg[2345678];

int main(){
	cin>>n>>m;

	rep(it,m){
		int u,v,w;
		scanf("%d%d%d",&u,&v,&w);
		--u,--v;

		if(w==2){
			biEdge[u].push_back(make_pair(it,v));
			biEdge[v].push_back(make_pair(it,u));
		} else {
			uniEdge[u].push_back(v);
		}
	}

	int V = 0;
	rep(i,n){
		nodes[i].push_back(V++); //in:0
		nodes[i].push_back(V++); //out:1

		sort(biEdge[i].begin(),biEdge[i].end());

		rep(it,biEdge[i].size()){
			nodes[i].push_back(V++);
			nodes[i].push_back(V++);
			nodes[i].push_back(V++);
		}

		int m = biEdge[i].size();

		rep(it,biEdge[i].size()){
			int lt = it + 2;
			int rt = m + it + 2;
			int ct = m * 2 + it + 2;

			if(it>0)
				addE(nodes[i][lt],nodes[i][lt-1],0);
			if(it+1<m)
				addE(nodes[i][rt],nodes[i][rt+1],0);
		}
	}

	//build edge
	rep(i,n){
		rep(it,uniEdge[i].size()){
			int v = uniEdge[i][it];//i->v

			addE(nodes[i][1],nodes[v][0],1);
		}

		int m = biEdge[i].size();

		if(m > 0){
			rep(it,biEdge[i].size()){
				int lt = it + 2;
				int rt = m + it + 2;
				int ct = m * 2 + it + 2;

				if(it > 0){
					int id = biEdge[i][it-1].first;
					int v = biEdge[i][it-1].second;

					addE(nodes[i][lt],findNode(v,id,2),1);
				}

				if(it + 1 < m){
					int id = biEdge[i][it+1].first;
					int v = biEdge[i][it+1].second;

					addE(nodes[i][rt],findNode(v,id,2),1);
				}

				addE(nodes[i][ct],nodes[i][lt],0);

				addE(nodes[i][ct],nodes[i][rt],0);

				addE(nodes[i][ct],nodes[i][1],0);
			}
			addE(nodes[i][0],nodes[i][2+m],0);
			{
				int id = biEdge[i][0].first;
				int v = biEdge[i][0].second;

				addE(nodes[i][0],findNode(v,id,2),1);
			}
		}

		addE(nodes[i][0],nodes[i][1],0);
	}

	//graph built
	rep(i,V){
		rep(j,edge[i].size())
			indeg[edge[i][j].t]++;
	}

	static int que[2345678],qh=0,qt=0;

	rep(i,V) if(indeg[i]==0) que[qt++]=i;

	while(qh<qt){
		int u = que[qh++];
		rep(j,edge[u].size()){
			int v = edge[u][j].t;
			indeg[v]--;
			if(!indeg[v])
				que[qt++] = v;
		}
	}

	static int dp[2345678];

	if(qt!=V){
		puts("Infinite");
	} else {
		rep(i,V){
			int u = que[V-1-i];
			dp[u]=0;
			rep(j,edge[u].size()){
				int v = edge[u][j].t;
				dp[u] = max(dp[u],dp[v] + edge[u][j].w);
			}
		}
		int ans=*max_element(dp,dp+V);
		printf("%d\n",ans);
	}
}