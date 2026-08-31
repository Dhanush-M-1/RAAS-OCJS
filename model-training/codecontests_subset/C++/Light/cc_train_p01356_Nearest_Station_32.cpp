#include <iostream>
#include <fstream>
#include <cassert>
#include <typeinfo>
#include <vector>
#include <stack>
#include <cmath>
#include <set>
#include <map>
#include <string>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <iomanip>
#include <cctype>
#include <random>
#include <complex>
#define syosu(x) fixed<<setprecision(x)
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int> P;
typedef pair<double,double> pdd;
typedef pair<ll,ll> pll;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<double> vd;
typedef vector<vd> vvd;
typedef vector<ll> vl;
typedef vector<vl> vvl;
typedef vector<char> vc;
typedef vector<vc> vvc;
typedef vector<string> vs;
typedef vector<bool> vb;
typedef vector<vb> vvb;
typedef vector<P> vp;
typedef vector<vp> vvp;
typedef vector<pll> vpll;
typedef pair<int,P> pip;
typedef vector<pip> vip;
const int inf=1<<29;
const ll INF=1ll<<60;
const double pi=acos(-1);
const double eps=1e-7;
const ll mod=1e9+7;
const int dx[4]={0,1,0,-1},dy[4]={1,0,-1,0};

ll n,m,a,b,p,q;

int main(){
	cin>>n>>m>>a>>b>>p>>q;
	if(a==1&&b==1){
		ll x=p+q,tmp=min(m/x,n),res=m-x*tmp;
		if(tmp!=n) res=min(res,x*(tmp+1)-m);
		cout<<res<<endl;
		return 0;
	}
	vl x;
	bool B=0;
	int I=0;
	do{
		if(p+q>m) B=1;
		x.push_back(p+q);
		if(INF/p>a) p*=a;
		else break;
		if(INF/q>b) q*=b;
		else break;
		I++;
	}while(I<n&&!B);
	int S=x.size(),S2=S/2,T=S-S2;
	vl c(1<<S2);
	for(int i=0;i<1<<S2;i++){
		for(int j=0;j<S2;j++) if(i&1<<j) c[i]+=x[j];
	}
	sort(c.begin(),c.end());
	ll res=INF;
	for(int i=0;i<1<<T;i++){
		ll tmp=0;
		for(int j=0;j<T;j++) if(i&1<<j) tmp+=x[S2+j];
		auto it=lower_bound(c.begin(),c.end(),m-tmp);
		if(it!=c.end()) res=min(res,abs(m-tmp-*it));
		if(it!=c.begin()) res=min(res,abs(m-tmp-*(it-1)));
	}
	cout<<res<<endl;
}