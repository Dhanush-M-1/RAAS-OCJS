// Bhagya Kamal Jain

#include<bits/stdc++.h>

#define ll          long long
#define pb          push_back
#define endl        '\n'
#define mii         map<ll int,ll int>
#define pii         pair<ll int,ll int>
#define vi          vector<ll int>
#define all(a)      (a).begin(),(a).end()
#define F           first
#define S           second
#define hell        1000000007
#define sim         template < class c
#define ris         return * this
#define dor         > debug & operator <<
#define eni(x)      sim > typename \
  enable_if<sizeof dud<c>(0) x 1, debug&>::type operator<<(c i) {

using namespace std;

sim > struct rge {c b, e; };
sim > rge<c> range(c i, c j) { return rge<c>{i, j}; }
sim > auto dud(c* x) -> decltype(cout << *x, 0);
sim > char dud(...);
struct debug 
{
	~debug() 
	{ 
		cout<<endl; 
	}
	eni(!=) cout << boolalpha << i; ris; }
	eni(==) ris << range(begin(i), end(i)); }
	sim, class b dor(pair < b, c > d) 
	{
		ris << "(" << d.first << ", " << d.second << ")";
	}
	sim dor(rge<c> d) 
	{
	  	*this << "[";
	  	for (auto it = d.b; it != d.e; ++it)
	    	*this << ", " + 2 * (it == d.b) << *it;
	  	ris << "]";
	}
};
#define fuck(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "

#define N  10005

ll int dp[N];
ll int tmp[N];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int TESTS=1;
	// cin>>TESTS;
	while(TESTS--)
	{
		ll int n;
		cin >> n;
		ll int c[n + 1];
		for(ll int i = 1; i <= n; i++) cin >> c[i];
		ll int b[n];
		for(ll int i = 1; i < n; i++) cin >> b[i];
		
		ll int q;
		cin >> q;
		while(q--)
		{
			ll int x;
			cin >> x;
			ll int arr[n + 1];
			arr[1] = x;
			for(ll int i = 2; i <= n; i++)
			{
				arr[i] = arr[i - 1] + b[i - 1];
			}
			ll int val[n + 1];
			val[0] = 0;
			for(ll int i = 1; i <= n; i++)
			{
				val[i] = val[i - 1] + arr[i];
			}

		dp[0] = 1;
		for(ll int i = 1; i <= n; i++)
		{
			for(ll int j = 0; j < N; j++)
			{
				tmp[j] = dp[j];
			}
			memset(dp, 0, sizeof(dp));
			for(ll int j = 0; j < N; j++)
			{
				for(ll int k = 0; k <= c[i]; k++)
				{
					if(k + j < N) dp[k + j] = (dp[k + j] + tmp[j]) % hell;
				}
			}
			for(ll int j = 0; j < N; j++)
			{
				if(j < val[i]) dp[j] = 0;
			}
		}

			ll int ans = 0;
			for(ll int j = 0; j < N; j++)
			{
				ans = (ans + dp[j]) % hell;
			}
			cout << ans << endl;
		}
	}
	return 0;
}