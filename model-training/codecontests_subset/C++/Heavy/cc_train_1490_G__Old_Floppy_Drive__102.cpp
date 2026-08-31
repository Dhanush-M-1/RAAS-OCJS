//in dp prefix suffix sum helps..
#include<iostream>
#include<vector>
#include<string.h>
#include<algorithm>
#include<iomanip>
#include<cmath>
#include<stack>
#include <iterator>
#include <map>
#include<list>
#include <fstream>
#include<unordered_map>
#include<set>
#include<queue>
#define int  long long
#define double long double
#define pb   push_back
#define mp   make_pair
#define pii  pair<int,int>
#define pip pair<int, pair<int, int> >
#define viv vector<vector<int> >
#define vip vector< pair<int, int> >
#define vi vector<int>
#define mii  map<int, int>
#define qu queue<int>
#define set set<int>
#define multi multiset<int>
#define stack stack<int>
#define fi first
#define se second
#define reverse(s) reverse(s.begin(), s.end())
#define sort1(v) sort(v.begin(), v.end())
#define it iterator
#define pq1 priority_queue <pii, vector<pii>, greater<pii> >
#define mem(x, y) memset(x, (int)y, sizeof(x))
#define ps(x,y) fixed<<setprecision(y)<<x
// author :: Anurag Anand.
using namespace std;
int z=  1e9+7;
//int z= 998244353;
int gcd(int a, int b){
    if(a==0)return b;
    if(b==0)return a;
    return gcd(b, a%b);
}
int power(int a,int b)
{
	int res=1;
	while(b)
	{
		if(b&1)
		{
			res=(res*a)%z;
			b--;
		}
		else
		{
			a=(a*a)%z;
			b=b>>1;
		}
	}
	return res;
}
vi sieve;
// vi seg;
// void arrange(int i, int v, int x, int lx, int rx){
// 	if(rx-lx==1){
// 		seg[x] =v;
// 		return;
// 	}
// 	int m= (lx+rx)/2;
// 	if(i<m){
// 		arrange(i, v, 2*x+1, lx, m);
// 	}
// 	else arrange(i, v, 2*x+2, m, rx);
// 	seg[x]=seg[2*x+1]+seg[2*x+2];
// }
// int calc(int l, int r, int x, int lx, int rx){
// 	    if(l>=rx||r<=lx) return 0;
// 	    if(lx>=l&&rx<=r) return seg[x];
// 	    int mid=(lx+rx)/2;
// 	    int sl= calc(l, r, 2*x+1, lx, mid), sr= calc(l, r, 2*x+2, mid, rx);
// 	    return sl+sr;
// }
int32_t main()
{
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);
	vi pp;
	pp.assign(1000001, 0);
	for(int i=2;i<1000;i++){
		if(!pp[i]){
			for(int j=i*i;j<=1000000;j+=i){
				pp[j]=1;
			}
		}
	}
	for(int i=2;i<=1000000;i++) if(!pp[i]) sieve.pb(i);
	int t;
	t=1;
	cin>>t;
	while(t--){
		int n, m;
		cin>>n>>m;
		int ar[n], ans[m];
		for(int i=0;i<n;i++) cin>>ar[i];
		for(int i=1;i<n;i++) ar[i]+=ar[i-1];
		int sum=ar[n-1];
		vip v;
		for(int i=0;i<n;i++){
			v.pb(mp(ar[i], i));
		}
		sort1(v);
		for(int i=n-2;i>=0;i--){
			if(v[i].se>v[i+1].se) v[i].se= v[i+1].se;
		}
		int mx=v[n-1].fi;
		for(int i=0;i<m;i++){
			int x;
			cin>>x;
			int l=0, r=n-1, a=-1;
			while(l<=r){
				int mid=(l+r)/2;
				if(v[mid].fi>=x){
					a=mid;
					r= mid-1;
				}
				else l= mid+1;
			}
			if(a!=-1) ans[i]= v[a].se;
			else{
				if(sum<=0) ans[i]=-1;
				else{
					int k= (x-mx)/sum;
					if((x-mx)%sum) k++;
					x-=k*sum;
					l=0, r=n-1, a=-1;
					while(l<=r){
					int mid=(l+r)/2;
					if(v[mid].fi>=x){
						a=mid;
						r= mid-1;
					}
					else l= mid+1;
					}
					ans[i]= v[a].se+k*n;
				}
			}
		}
		for(int i=0;i<m;i++) cout<<ans[i]<<" ";
		cout<<"\n";
	}
}