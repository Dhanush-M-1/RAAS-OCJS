//To debug :  g++ -g file.cpp -o code
//to flush output : fflush(stdout) or cout.flush()
//cout<<setprecision(p)<<fixed<<var
//use 1LL<<i to for 64 bit shifting , (ll)2 because by default 2 is ll
//take care of precedence rule of operators 
//do not forget to change the sizes of arrays and value of contants and other things after debugging  
 
#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define rep(i,a,n) for(i=a;i<n;++i)
#define irep(i,n,a) for(i=n;i>a;--i)
#define mod 1000000007
#define pb push_back
#define big 9223372036854775807
#define big1 LONG_MAX
#define big2 ll_MAX
#define big3 1000000000
#define sma1 LONG_MIN
#define sma2 ll_MIN
#define sma3 -1000000000
#define mp make_pair
#define dub double
#define ivec vector<ll>
#define lvec vector<long long>
#define cvec vector<char>
#define svec vector<string>
#define mt make_tuple
#define MOD 998244353
#define ld long double
#define pi acos(-1.0)
 
#define SZ(x)  (ll)(x.size())
 
//comment the below if not required
 
/*
 
#define ss second.second
#define ff first.first
#define f first
#define s second
#define sf second.first
#define fs first.second
*/
 
#define IOS std::ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
 
//cout<<"Case #"<<c<<": "<<ans<<"\n" ;

const ll N = 2e5+1;

ll n,m;

ll M[N],a[N],ps[N],ans[N],val,res,i,sz;

vector<pair<ll,ll>> v;

int main()
{
	IOS;

	ll t,s,temp,l,r,mid,mx;

	cin>>t;

	while(t--)
	{
		cin>>n>>m;

		s = 0;

		v.clear();

		rep(i,1,n+1){
			cin>>a[i];
			s+=a[i];

			if(s>0)
				v.pb({s,i});
		}

		rep(i,1,m+1){
			cin>>M[i];
		}

		sort(v.begin(),v.end());

		sz = SZ(v);

		if(sz==0)
		{
			rep(i,1,m+1)
				cout<<-1<<" ";

			cout<<"\n";

			continue;
		}

		mx = v[sz-1].first;

		temp = LLONG_MAX;

		for(i=sz-1;i>=0;--i)
		{
			temp = min(temp,v[i].second);
			ps[i]=temp;
		}

		for(i=1;i<=m;++i)
		{
			ans[i] = 0;
			if(M[i]>mx)
			{
				if(s<=0)
				{
					ans[i]=-1;
					continue;
				}

				temp = (M[i]-mx+s-1)/s;
				ans[i]  = temp*n;
				M[i] -= temp*s;
			}

			l = 0 , r = sz-1;

			res = LLONG_MAX;

			while(l<=r)
			{
				mid = (l+r)/2;

				if(v[mid].first>=M[i])
				{
					res = ps[mid];
					r = mid-1;
				}
				else
				{
					l = mid+1;
				}
			}

			ans[i] += res-1;

		}

		for(i=1;i<=m;++i)
				cout<<ans[i]<<" ";

		cout<<"\n";
	}


	return 0;
}