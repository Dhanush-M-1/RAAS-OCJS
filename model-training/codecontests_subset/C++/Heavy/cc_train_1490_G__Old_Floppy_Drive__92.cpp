#include <bits/stdc++.h>
#define pb push_back
#define fi first
#define se second
#define all(X) (X).begin(),(X).end()
#define ln "\n"
#define out cout
#define NON_TOGLIERE ios_base::sync_with_stdio(0); cin.tie(0);
#define ll long long
#define VI vector<int>
#define pii pair<int,int>
#define pll pair<long long,long long>
#define PQ priority_queue
#define sz(v) ((int)v.size())
#define inf 1000000001
#define maxn 200010
using namespace std;
#if ONLINE_JUDGE
    #define in cin
#else
	ifstream in("input.txt");
#endif
 
ll n,i,Q,T,j,k,m,t,x,y,mam,v[maxn],s[maxn],q[maxn],p[maxn];
 
int main(){
	NON_TOGLIERE
	in>>Q;
	for(T=1;T<=Q;T++){
		in>>n>>m;mam=0;ll fine=0;
		vector<pll>kek;
		for(i=0;i<n;i++)in>>v[i];
		s[0]=mam=v[0];
		if(v[0]>0)kek.pb({v[0],0ll});
		for(i=1;i<n;i++){
			s[i]=v[i]+s[i-1];
			if(s[i]>mam){
				mam=s[i];
				kek.pb({mam,i});
			}
		}
	//for(auto y:kek)cout<<y.fi<<" ";out<<ln;
		for(i=0;i<m;i++){
			fine=0;
			in>>x;
			if(x>mam&&s[n-1]<=0){
				cout<<-1<<" ";continue;
			}
			if(x>mam){//cout<<x<<ln;
				k=x-mam;
				k=(k-1+s[n-1])/s[n-1];
				x-=k*s[n-1];
				fine+=n*k;
				
			}
			if(x==0){
				cout<<fine<<" "; continue;
			}
			pll tmp={x,0ll};
			auto ind=lower_bound(all(kek),tmp);
			int cel=(int)(ind-kek.begin());
			fine+=kek[cel].se;
			cout<<fine<<" ";
			
			
			
		}
		out<<ln;
 
	}
}