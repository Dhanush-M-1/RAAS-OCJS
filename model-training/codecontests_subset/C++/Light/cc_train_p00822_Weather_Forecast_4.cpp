#include<iostream>
#include<vector>
#include<string>
#include<algorithm>	
#include<map>
#include<set>
#include<utility>
#include<cmath>
#include<cstring>
#include<queue>
#include<stack>
#include<cstdio>
#include<sstream>
#include<iomanip>
#include<assert.h>
#define loop(i,a,b) for(int i=a;i<b;i++) 
#define rep(i,a) loop(i,0,a)
#define pb push_back
#define all(in) in.begin(),in.end()
#define shosu(x) fixed<<setprecision(x)
using namespace std;
//kaewasuretyuui
typedef long long ll;
typedef int Def;
typedef pair<Def,Def> pii;
typedef vector<Def> vi;
typedef vector<vi> vvi;
typedef vector<pii> vp;
typedef vector<vp> vvp;
typedef vector<string> vs;
typedef vector<double> vd;
typedef vector<vd> vvd;
typedef pair<Def,pii> pip;
typedef vector<pip>vip;
//#define mt make_tuple
//typedef tuple<int,string> tp;
//typedef vector<tp> vt;
const double PI=acos(-1);
const double EPS=1e-7;
const int inf=1e9;
const ll INF=2e18;
int dx[]={0,1,0,-1,0,2,0,-2,0};
int dy[]={1,0,-1,0,2,0,-2,0,0};
int f(vp in){
	int a=0;
	for(int i=5;i>=0;i--){
		a*=9;
		a+=in[i].first*3+in[i].second;
	}
	return a;
}
vp F(int a){
	vp out;
	rep(i,6){
		int b=a%9;
		out.pb(pii(b/3,b%3));
		a/=9;
	}
	return out;
}
vi dp;
int main(){
	int n;
	while(cin>>n,n){
		vvi in(n,vi(16));
		rep(i,n)rep(j,16)cin>>in[i][j];
		int N=531441;
		dp=vi(N);
		vp qwr(6,pii(1,1));
		dp[f(qwr)]=1;
		rep(i,n){
			vi ndp(N);
			rep(j,N)if(dp[j])rep(k,9){
				if(i==0&&k!=8)continue;
				vp ka=F(j);
				pii now=ka[5];
				now.first+=dx[k];
				now.second+=dy[k];
				if(now.first<0||now.first>=3||now.second<0||now.second>=3)continue;
				ka.pb(now);
				bool h=true;
				if(in[i][now.first*4+now.second])continue;
				if(in[i][now.first*4+now.second+1])continue;
				if(in[i][now.first*4+now.second+4])continue;
				if(in[i][now.first*4+now.second+5])continue;
				rep(l,16){
					bool H=false;
					rep(x,7){
						if(ka[x].first*4+ka[x].second==l)H=true;
						if(ka[x].first*4+ka[x].second+1==l)H=true;
						if(ka[x].first*4+ka[x].second+4==l)H=true;
						if(ka[x].first*4+ka[x].second+5==l)H=true;
					}
					if(!H)h=false;
				}
				ka.erase(ka.begin());
				if(i<6||h)ndp[f(ka)]=true;
			}
			dp=ndp;
//			rep(j,N)if(dp[j]){
//				vp tmp=F(j);
//				rep(k,tmp.size())cout<<tmp[k].first<<" "<<tmp[k].second<<endl;
//				cout<<endl;
//			}
		}
		bool h=false;
		rep(i,N)if(dp[i])h=true;
		cout<<h<<endl;
	}
}