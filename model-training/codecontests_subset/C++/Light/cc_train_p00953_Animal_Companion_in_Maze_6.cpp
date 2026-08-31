#include <bits/stdc++.h>
#define rep(i,N) for(int i=0;i<(int)N;i++)
#define rep1(i,N) for(int i=1;i<=(int)N;i++)
#define pb push_back
#define all(c) c.begin(),c.end()
#define show(x) cout<<#x<<" "<<x<<endl
#define chmax(x,y) x=max(x,y)
#define BEGIN_STACK_EXTEND(size) void * stack_extend_memory_ = malloc(size);void * stack_extend_origin_memory_;char * stack_extend_dummy_memory_ = (char*)alloca((1+(int)(((long long)stack_extend_memory_)&127))*16);*stack_extend_dummy_memory_ = 0;asm volatile("mov %%rsp, %%rbx\nmov %%rax, %%rsp":"=b"(stack_extend_origin_memory_):"a"((char*)stack_extend_memory_+(size)-1024));
#define END_STACK_EXTEND asm volatile("mov %%rax, %%rsp"::"a"(stack_extend_origin_memory_));free(stack_extend_memory_);
using namespace std;
const int MN=100000;
struct edge {int to,w,rev;};
typedef vector< vector<edge> > Graph;
Graph G,oG;
void add_edge(int x,int y,int w,int way){
	if(way==1){
		G[x].pb({y,w,-1});
	}else{
		int X=G[x].size(),Y=G[y].size();
		G[x].pb({y,w,Y});
		G[y].pb({x,w,X});
	}
}

typedef pair<int,int> P;
int memo[300000][4];
bool vis[300000][4];
int inf=1e8;
int dfs(int v,int eid){
	eid++;
	if(memo[v][eid]!=-1) return memo[v][eid];
	if(vis[v][eid]){
		return inf;
//		puts("Infinite");
	}
	vis[v][eid]=1;
	int ret=0;
	// rep(i,G[v].size()) if(i!=eid-1){
	// 	edge& e=G[v][i];
	// 	chmax(ret,dfs(e.to,e.rev)+e.w);
	// }
	if(G[v].size()>0 && eid!=1) chmax(ret,dfs(G[v][0].to,G[v][0].rev)+G[v][0].w);
	if(G[v].size()>1 && eid!=2) chmax(ret,dfs(G[v][1].to,G[v][1].rev)+G[v][1].w);
	if(G[v].size()>2 && eid!=3) chmax(ret,dfs(G[v][2].to,G[v][2].rev)+G[v][2].w);
	memo[v][eid]=ret;
	return ret;
}

int rs[100001]={};
int its[100000]={};

int main(){
	BEGIN_STACK_EXTEND(128*1024*1024);
	int N,M;
	cin>>N>>M;
	oG.resize(N);
	rep(i,M){
		int x,y,w;
		scanf("%d %d %d",&x,&y,&w);
		x--,y--;
		if(w==1){
			oG[x].pb(edge{y,1,-1});
		}else{
			int X=oG[x].size(),Y=oG[y].size();
			oG[x].pb(edge{y,1,Y});
			oG[y].pb(edge{x,1,X});
		}
	}
	int newN=0;
	rep(i,N){
		int sz=oG[i].size();
		if(sz==0) sz=1;
		rs[i]=newN;
		its[i]=rs[i];
		newN+=sz;
	}
	rs[N]=newN;
	G.resize(newN);
	rep(x,N){
		int n=rs[x+1]-rs[x];
		for(int v=rs[x];v<rs[x]+n-1;v++) add_edge(v,v+1,0,2);
		for(edge e: oG[x]){
			if(e.rev==-1){	//one way
				add_edge(its[x],rs[e.to],1,1);
				its[x]++;
			}else{
				if(x<e.to){
					add_edge(its[x],its[e.to],1,2);
					its[x]++;
					its[e.to]++;
				}
			}
		}
	}
	int ans=0;
	N=newN;
//	rep(i,N) assert(G[i].size()<=3);
	rep(i,N) rep(j,4) memo[i][j]=-1;
	rep(i,N) chmax(ans,dfs(i,-1));
	if(ans>=inf) puts("Infinite");
	else cout<<ans<<endl;
	END_STACK_EXTEND;
}