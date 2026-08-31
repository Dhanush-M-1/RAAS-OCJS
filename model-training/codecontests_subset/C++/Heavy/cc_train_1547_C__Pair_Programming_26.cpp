#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define dd double
#define MOD 1000000007
#define MAX LONG_LONG_MAX
#define MIN LONG_LONG_MIN
#define nl cout << endl
#define mp make_pair
#define fr(i, a, b) for (ll i = a; i < b; i++)
#define frr(i, b, a) for (ll i = b - 1; i >= a; i--)

#define pb push_back
#define ff first
#define max3(a, b, c) max(c, max(a, b))
#define min3(a, b, c) min(c, min(a, b))
#define pre(p) cout.precision(p)
#define in(n) cin >> n
#define fo(i, n) for (ll i = 0; i < n; i++)
#define Fo(i, k, n) for (ll i = k; k < n ? i < n : i > n; k < n ? i += 1 : i -= 1)
#define clr(x) memset(x, 0, sizeof(x))
#define tr(it, a) for (auto it = a.begin(); it != a.end(); it++)
#define all(v) v.begin(), v.end()
#define s(ar, n) sort(ar, ar + n)
#define rs(ar, n) sort(ar, ar + n, greater<ll>())
#define cn(a, n)               \
	for (ll i = 0; i < n; i++) \
		cin >> a[i];
#define cn1(a, n)               \
	for (ll i = 1; i <= n; i++) \
		cin >> a[i];
//#define reverse(a, n)   for(ll i=0;i<n/2;i++){ll temp = a[i];a[i]=a[n-i-1];a[n-i-1]=temp;}
#define ov(a, n)               \
	for (ll i = 0; i < n; i++) \
		cout << a[i] << " ";   \
	nl
#define ovv(v)                        \
	for (ll i = 0; i < v.size(); i++) \
		cout << v[i] << " ";          \
	nl
#define ovp(a, n)              \
	for (ll i = 0; i < n; i++) \
		cout << a[i].ff << " " << a[i].ss << " ";
#define maxa(ar, N) *max_element(ar, ar + N)
#define mina(ar, N) *min_element(ar, ar + N)
#define fastio()                  \
	ios_base::sync_with_stdio(0); \
	cin.tie(0);                   \
	cout.tie(0)
typedef pair<ll, ll> pii;
#define vl vector<ll>
ll gcd(ll a, ll b)
{
	while (b)
	{
		a %= b;
		swap(a, b);
	}
	return a;
}
ll lcm(ll a, ll b) { return (a * b) / gcd(a, b); }
ll powe(ll n, ll m)
{
	if (m == 0)
		return 1;
	ll t = powe(n, m / 2);
	if (m % 2 == 0)
		return (t * t);
	return (((t * t)) * n);
}
ll mpowe(ll n, ll m)
{
	if (m == 0)
		return 1;
	ll t = powe(n, m / 2);
	t %= MOD;
	if (m % 2 == 0)
		return (t * t) % MOD;
	return (((t * t) % MOD) * n) % MOD;
}
ll logtwo(ll n)
{
	if (n == 1)
		return 0;
	return logtwo(n / 2) + 1;
}
ll binpow(ll a, ll b, ll m)
{
	a %= m;
	ll res = 1;
	while (b > 0)
	{
		if (b & 1)
			res = res * a % m;
		a = a * a % m;
		b >>= 1;
	}
	return res;
}
ll calculateNcR(ll n, ll r)
{
	if (n < r)
		return 0;
	ll p = 1, k = 1;
	if (n - r < r)
		r = n - r;
	if (r != 0)
	{
		while (r)
		{
			p *= n;
			k *= r;
			ll m = gcd(p, k);
			p /= m;
			k /= m;
			n--;
			r--;
		}
	}
	else
		p = 1;
	return p;
}
ll stringToInt(string s)
{
	ll num = 0;
	fr(i, 0, s.length()) { num = num * 10 + (s[i] - '0'); }
	return num;
}
void output(ll n) { cout << "Case #" << n << ": "; }
ll A[10000005];
void vecIn(vector<ll> &v, ll n)
{
	for (ll i = 0; i < n; i++)
	{
		cin >> v[i];
	}
}
void print(vector<ll> v)
{
	for (ll i = 0; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}
	cout << endl;
}

bool cmp(vl &a, vl &b)
{
	if (a[1] != b[1])
		return a[1] < b[1];
	return a[0] > b[0];
}

int main()
{
	fastio();
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	ll t;
	cin >> t;
	while (t--)
	{
		ll k,n,m;
		cin >> k>>n>>m;
		queue<ll> arr;
		queue<ll> brr;
		for(int i=0;i<n;i++)
		{
			ll temp; cin >> temp;
			arr.push(temp);

		}
		for(int i=0;i<m;i++)
		{
			ll temp; cin >> temp;
			brr.push(temp);

		}



		queue<ll> ans;
		bool flag=true;
		ll cs=k;
	
		while(!arr.empty() and !brr.empty())
		{
			if(arr.front()==0)
			{
				ans.push(0);
				arr.pop();
				cs++;
			}
			else if(brr.front()==0)
			{
				ans.push(0);
				brr.pop();
				cs++;
			}
			else
			{
				if(min(arr.front(), brr.front()) > cs)
				{
					flag = false;
					break;
				}
				else if(arr.front()<=brr.front())
				{
					ans.push(arr.front());
					arr.pop();
				}
				else 
				{
					ans.push(brr.front());
					brr.pop();
				}
			}
		}

		while(!arr.empty())
		{
			if(arr.front()==0)
			{
				ans.push(0);
				arr.pop();
				cs++;
			}
			else if(arr.front()>cs)
			{
				flag = false;
					break;
			}
			else
			{
				ans.push(arr.front());
					arr.pop();
			}
		}

		while(!brr.empty())
		{
			if(brr.front()==0)
			{
				ans.push(0);
				brr.pop();
				cs++;
			}
			else if(brr.front()>cs)
			{
				flag = false;
					break;
			}
			else
			{
				ans.push(brr.front());
					brr.pop();
			}
		}

		if(!flag)
			cout<<-1<<endl;
		else
		{
			while(!ans.empty())
			{
				cout<<ans.front()<<" ";
				ans.pop();
			}
			cout<<endl;
		}


	}
	

}
