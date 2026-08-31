#include <bits/stdc++.h>
using namespace std;

#define dump(n) cout<<"# "<<#n<<'='<<(n)<<endl
#define repi(i,a,b) for(int i=int(a);i<int(b);i++)
#define peri(i,a,b) for(int i=int(b);i-->int(a);)
#define rep(i,n) repi(i,0,n)
#define per(i,n) peri(i,0,n)
#define all(c) begin(c),end(c)
#define mp make_pair
#define mt make_tuple

typedef unsigned int uint;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int> pii;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<ll> vl;
typedef vector<vl> vvl;
typedef vector<double> vd;
typedef vector<vd> vvd;
typedef vector<string> vs;

const int INF=1e9;
const int MOD=1e9+7;
const double EPS=1e-9;

template<typename T1,typename T2>
ostream& operator<<(ostream& os,const pair<T1,T2>& p){
	return os<<'('<<p.first<<','<<p.second<<')';
}
template<typename T>
ostream& operator<<(ostream& os,const vector<T>& a){
	os<<'[';
	rep(i,a.size()) os<<(i?" ":"")<<a[i];
	return os<<']';
}

// (i,j)を左上とする2x2領域で祭りが開かれている
bool conflict(int c,int i,int j)
{
	return c&0x33<<i*4+j;
}
// 7日間雨が降らなかった地域がある
bool left7days(ull b)
{
	return b+0x1111111111111111ull&0x8888888888888888ull;
}
// (i,j)を左上とする2x2領域に雨を降らせた日の翌日
ull next(ull b,int i,int j)
{
	return b+0x1111111111111111ull&~(0xff00ffull<<(i*4+j)*4);
}

namespace std{
	template<>
	struct hash<tuple<int,int,ull>>{
		size_t operator()(const tuple<int,int,ull>& t)const{
			const char* ptr=(const char*)(&t);
			size_t res=2166136261;
			rep(i,sizeof(t)) (res^=*ptr++)*=16777619;
			return res;
		}
	};
}

int main()
{
	for(int n;cin>>n && n;){
		vector<int> cs(n);
		rep(i,n) rep(j,16){
			int x; cin>>x;
			cs[i]|=x<<j;
		}
		
		queue<tuple<int,int,ull>> q;
		q.emplace(1,1,0);
		rep(d,n){
			decltype(q) q2;
			unordered_set<tuple<int,int,ull>> vis;
			while(q.size()){
				auto cur=q.front(); q.pop();
				int i,j; ull b; tie(i,j,b)=cur;
				if(i<0 || 3<=i || j<0 || 3<=j) continue;
				if(conflict(cs[d],i,j)|| left7days(b)) continue;
				if(vis.count(cur)) continue;
				vis.insert(cur);
				rep(k,4) rep(l,3){
					int ni=i+"\xff\x1\0\0"[k]*l,nj=j+"\0\0\xff\x1"[k]*l;
					q2.emplace(ni,nj,next(b,i,j));
				}
			}
			swap(q,q2);
		}
		
		bool res=false;
		while(q.size()){
			res|=!left7days(get<2>(q.front()));
			q.pop();
		}
		cout<<res<<endl;
	}
}