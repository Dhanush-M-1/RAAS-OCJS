#include <algorithm>
#include <bitset>
#include <cassert>
#include <cctype>
#include <climits>
#include <cmath>
#include <complex>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>
#include <deque>
#include <fstream>
#include <iomanip>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <valarray>
#include <vector>

#define EPS 1e-9
#define INF 1070000000LL
#define MOD 1000000007LL
#define fir first
#define foreach(it,X) for(__typeof((X).begin()) it=(X).begin();it!=(X).end();it++)
#define ite iterator
#define mp make_pair
#define rep(i,n) rep2(i,0,n)
#define rep2(i,m,n) for(int i=m;i<(n);i++)
#define pb push_back
#define sec second
#define sz(x) ((int)(x).size())

using namespace std;

struct timer{
	time_t start;
	timer(){start=clock();}
	~timer(){cerr<<1.*(clock()-start)/CLOCKS_PER_SEC<<" secs"<<endl;}
};

typedef istringstream iss;
typedef long long ll;
typedef pair<int,int> pi;
typedef stringstream sst;
typedef vector<int> vi;

ll n,m,a,b,p,q;
vector<ll> v;

int main(){
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	
	cin>>n>>m>>a>>b>>p>>q;
	if(a==1 && b==1){
		ll t=p+q;
		if(n < (m+t-1)/t){
			cout<<m-t*n<<endl;
		}else{
			cout<<min(m%t,t-m%t)<<endl;
		}
		return 0;
	}
	vector<ll> v;
	ll pa=p,qb=q;
	double pa_=p,qb_=q;
	rep(i,n){
		if(pa_+qb_>3*m)break;
		if(pa+qb>2*m)break;
		v.pb(pa+qb);
		pa*=a,qb*=b;
		pa_*=a,qb_*=b;
	}
	//rep(i,sz(v))cout<<v[i]<<" ";cout<<endl;
	
	vector<ll> v0,v1,sum;
	int N=sz(v)/2;
	rep(i,sz(v)){
		if(i<N)v0.pb(v[i]);
		else v1.pb(v[i]);
	}
	rep(mask,1<<sz(v1)){
		ll s=0;
		rep(i,sz(v1))if(mask>>i&1){
			s+=v1[i];
		}
		sum.pb(s);
	}
	sort(sum.begin(),sum.end());
	
	ll ans=m;
	rep(mask,1<<sz(v0)){
		ll s=0;
		rep(i,sz(v0))if(mask>>i&1){
			s+=v0[i];
		}
		if(s>=m){
			ans=min(ans,s-m);
		}else{
			ll rest=m-s;
			vector<ll>::ite it=lower_bound(sum.begin(),sum.end(),rest);
			if(it!=sum.end())ans=min(ans,*it-rest);
			it--;
			ans=min(ans,rest-*it);
		}
	}
	cout<<ans<<endl;
}