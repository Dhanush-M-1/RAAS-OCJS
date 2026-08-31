#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")

#include <bits/stdc++.h>

using namespace std ;

const int inf = 1e9 ;
const int MAX = 2e5 + 10 ;

long long arr[MAX] ;
int val[MAX] , suff[MAX] ;
int n , q ;

vector<long long>v ;

long long sum = 0 ;

void compress()
{
	for(int i = 1 ; i <= n ; ++i)
		v.push_back(arr[i]) ;
	sort(v.begin() , v.end()) ;
	v.erase(unique(v.begin() , v.end()) , v.end()) ;
	for(int i = 1 ; i <= n ; ++i)
		arr[i] = lower_bound(v.begin() , v.end() , arr[i]) - v.begin() + 1 ;
}

void preprocess()
{
	for(int i = 1 ; i <= n ; ++i)
		arr[i] += arr[i-1] ;
	sum = arr[n] ;
	compress() ;
	for(int i = 1 ; i <= n ; ++i)
		val[i] = inf ;
	for(int i = 1 ; i <= n ; ++i)
		val[arr[i]] = min(val[arr[i]] , i) ;
	suff[n] = val[n] ;
	for(int i = n-1 ; i >= 1 ; --i)
		suff[i] = min(suff[i+1] , val[i]) ;
}

int check(long long a , long long x)
{
	long long y = a * sum ;
	if(y >= x)
		return 0 ;
	x -= y ;
	if(x > v.back())
		return inf ;
	int idx = lower_bound(v.begin() , v.end() , x) - v.begin() ;
	return suff[idx+1] ;
}

int main()
{
	ios_base::sync_with_stdio(0) ;
	cin.tie(0) ;
	int t ;
	cin>>t ;
	while(t--)
	{
		v.clear() ;
		cin>>n>>q ;
		for(int i = 1 ; i <= n ; ++i)
			cin>>arr[i] ;
		preprocess() ;
		while(q--)
		{
			int x ;
			cin>>x ;
			int ans = check(0 , x) ;
			if(ans != inf)
				cout<<ans-1<<" " ;
			else if(sum <= 0)
				cout<<-1<<" " ;
			else
			{
				long long l = 1 , r = (x+sum-1) / sum ;
				long long ans = r*n ;
				while(l <= r)
				{
					long long mid = (l + r) >> 1ll ;
					if(check(mid , x) != inf)
						ans = mid , r = mid-1 ;
					else
						l = mid+1 ;
				}
				ans = ans * n + check(ans , x) ;
				cout<<ans-1<<" " ;
			}
		}
		cout<<"\n" ;
	}
	return 0 ;
}		