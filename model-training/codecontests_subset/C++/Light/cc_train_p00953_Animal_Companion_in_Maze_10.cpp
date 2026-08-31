#include <string>
#include <vector>
#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<stack>
#include<queue>
#include<cmath>
#include<algorithm>
#include<functional>
#include<list>
#include<deque>
#include<bitset>
#include<set>
#include<map>
#include<unordered_map>
#include<unordered_set>
#include<cstring>
#include<sstream>
#include<complex>
#include<iomanip>
#include<numeric>
#include<cassert>
#define X first
#define Y second
#define pb push_back
#define rep(X,Y) for (int (X) = 0;(X) < (Y);++(X))
#define reps(X,S,Y) for (int (X) = S;(X) < (Y);++(X))
#define rrep(X,Y) for (int (X) = (Y)-1;(X) >=0;--(X))
#define rreps(X,S,Y) for (int (X) = (Y)-1;(X) >= (S);--(X))
#define repe(X,Y) for ((X) = 0;(X) < (Y);++(X))
#define peat(X,Y) for (;(X) < (Y);++(X))
#define all(X) (X).begin(),(X).end()
#define rall(X) (X).rbegin(),(X).rend()
#define eb emplace_back
#define UNIQUE(X) (X).erase(unique(all(X)),(X).end())
#define Endl endl

using namespace std;
typedef long long ll;
typedef pair<int,int> pii;
typedef pair<ll,ll> pll;
template<class T> using vv=vector<vector<T>>;
template<class T> ostream& operator<<(ostream &os, const vector<T> &t) {
os<<"{"; rep(i,t.size()) {os<<t[i]<<",";} os<<"}"<<endl; return os;}
template<class T,size_t n> ostream& operator<<(ostream &os, const array<T,n> &t) {
	os<<"{"; rep(i,n) {os<<t[i]<<",";} os<<"}"<<endl; return os;}
template<class S, class T> ostream& operator<<(ostream &os, const pair<S,T> &t) { return os<<"("<<t.first<<","<<t.second<<")";}
template<class S, class T,class U> ostream& operator<<(ostream &os, const tuple<S,T,U> &t) { return os<<"("<<get<0>(t)<<","<<get<1>(t)<<","<<get<2>(t)<<")";}
template<class S, class T,class U,class V> ostream& operator<<(ostream &os, const tuple<S,T,U,V> &t) { return os<<"("<<get<0>(t)<<","<<get<1>(t)<<","<<get<2>(t)<<","<<get<3>(t)<<")";}
template<class S, class T,class U,class V,class W> ostream& operator<<(ostream &os, const tuple<S,T,U,V,W> &t) { return os<<"("<<get<0>(t)<<","<<get<1>(t)<<","<<get<2>(t)<<","<<get<3>(t)<<","<<get<4>(t)<<")";}
template<class T> inline bool MX(T &l,const T &r){return l<r?l=r,1:0;}
template<class T> inline bool MN(T &l,const T &r){return l>r?l=r,1:0;}
//#undef NUIP
#ifdef NUIP
#define out(args...){vector<string> a_r_g_s=s_p_l_i_t(#args, ','); e_r_r(a_r_g_s.begin(), args); }
vector<string> s_p_l_i_t(const string &s, char c){vector<string> v;int d=0,f=0;string t;for(char c:s){if(!d&&c==',')v.pb(t),t="";else t+=c;if(c=='\"'||c=='\'')f^=1;if(!f&&c=='(')++d;if(!f&&c==')')--d;}v.pb(t);return move(v);}
void e_r_r(vector<string>::iterator it) {}
template<typename T, typename... Args> void e_r_r(vector<string>::iterator it, T a, Args... args){ if(*it==" 1"||*it=="1") cerr<<endl; else cerr << it -> substr((*it)[0] == ' ', it -> length()) << " = " << a << ", "; e_r_r(++it, args...);}
#else
#define out
#endif
#ifdef __cpp_init_captures
template<typename T>vector<T> table(int n, T v){ return vector<T>(n, v);}
template <class... Args> auto table(int n, Args... args){auto val = table(args...); return vector<decltype(val)>(n, move(val));}
#endif
const ll MOD=1e9+7;

struct UF{
  vector<int> data;
  UF(int size):data(size,-1){}
  bool unite(int x,int y){
    x=root(x); y=root(y);
    if(x!=y){
      if(-data[y]>-data[x]) swap(x,y);
      data[x]+=data[y]; data[y]=x;
    }
    return x!=y;
  }
  bool findSet(int x,int y){return root(x)==root(y);}
  int root(int x){return data[x]<0?x:data[x]=root(data[x]);}
  int size(int x) {return -data[root(x)];}
};

int main(){
  ios_base::sync_with_stdio(false);
  cout<<fixed<<setprecision(0);
	int n,m;
	cin>>n>>m;
	vv<int> g(n),h(n);
	vector<int> bi(n);
	UF uf(n);
	int ok=1;
	rep(i,m){
		int a,b,c;
		cin>>a>>b>>c; --a; --b;
		if(c==1){
			g[a].pb(b);
		}else{
			bi[a]=bi[b]=1;
			h[a].pb(b);
			h[b].pb(a);
			if(!uf.unite(a,b)) ok=0;
		}
	}
	if(!ok){
		cout<<"Infinite"<<Endl;
		return 0;
	}
	deque<int> que,todo;
	vector<int> usd(n),ind(n),cnt(n);
	rep(v,n)for(int w:g[v]) ++ind[w];
	vv<int> mem(n);
	rep(i,n) mem[uf.root(i)].pb(i);
	rep(i,n)if(ind[i]==0 && MX(usd[i],1)){
		if(bi[i]){
			if(++cnt[uf.root(i)]==uf.size(i)){
				todo.eb(uf.root(i));
			}
		}else{
			que.eb(i);
		}
	}
	vector<int> dp(n);
	vector<int> cs(n,-1),up(n,-1);
	function<int(int,int)> dfs=
		[&](int v,int p){
			int mx=dp[v];
			for(int w:h[v])if(w!=p) MX(mx,dfs(w,v)+1);
			return up[v]=mx;
		};
	function<void(int,int,int)> dfs2=
		[&](int v,int p,int dn){
			pii fst(dp[v],-1),snd(dn,p);
			if(fst<snd) swap(fst,snd);
			for(int w:h[v])if(w!=p){
					pii p(up[w]+1,w);
					if(fst<p){
						snd=fst; fst=p;
					}else if(snd<p){
						snd=p;
					}
				}
			dp[v]=fst.X;
			for(int w:h[v])if(w!=p) dfs2(w,v,(fst.Y==w?snd.X:fst.X)+1);
		};
	while(1){
		while(que.size()){
			int v=que.front(); que.pop_front();
			out(v,dp[v],1);
			for(int w:g[v]){
				MX(dp[w],dp[v]+1);
				if(--ind[w]==0 && MX(usd[w],1)){
					if(bi[w]){
						if(++cnt[uf.root(w)]==uf.size(w)){
							todo.eb(uf.root(w));
						}
					}else{
						que.eb(w);
					}
				}
			}
		}
		if(todo.empty()) break;
		out(dp,1);
		while(todo.size()){
			int x=todo.front(); todo.pop_front();
			dfs(x,-1);
			out(x,up,1);
			dfs2(x,-1,0);
			for(int y:mem[x]) que.eb(y);
		}
		out(cs,dp,1);
	}
	out(cs,1);
	if(*min_element(all(usd))==0) ok=0;
	if(!ok){
		cout<<"Infinite"<<Endl;
		return 0;
	}
	cout<<*max_element(all(dp))<<endl;
  return 0;
}

