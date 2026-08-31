#include<bits/stdc++.h>
#include<cmath>
using namespace std;


long long gcd(long long a, long long b)
{
	if (b == 0)
	{
		return a;
	}
	return gcd(b, a % b);
}

long long lcm(long long a, long long b)
{
	return (a / gcd(a, b)) * b;
}

bool prime(long long n)
{
	if (n == 1)
	{
		return false;
	}
	for (long long i = 2; i <= sqrt(n); i++)
	{
		if (n % i == 0)
		{
			return false;
		}
	}
	return true;
}

vector<long long> factors(long long n)
{
	vector<long long> ans;
	for (long long i = 2; i <= sqrt(n); i++)
	{
		if (n % i == 0)
		{
			ans.push_back(i);
			if (i != sqrt(n))
			{
				ans.push_back(n / i);
			}
		}
	}
	sort(ans.begin(), ans.end(), greater<int>());
	return ans;
}

int fact(int n)
{
	if (n == 1 || n == 0)
	{
		return n;
	}
	return (n * fact(n - 1));
}

bool compare(pair<int, int> a, pair<int, int> b)
{
	if (a.first == b.first)
	{
		return a.second < b.second;
	}
	return a.first < b.first;
}


void solve()
{
	int k, n, m;
	cin >> k >> n >> m;

	vector<int> a(n);
	vector<int> b(m);
	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	for (int i = 0; i < m; i++)
	{
		cin >> b[i];
	}
	vector<int> ans;
	int i = 0, j = 0;
	while (i < n || j < m)
	{
		if (i < n && a[i] == 0)
		{
			ans.push_back(a[i]);
			i++;
			k++;
		}
		else if (j < m && b[j] == 0)
		{
			ans.push_back(b[j]);
			j++;
			k++;
		}
		else if (i < n && a[i] <= k)
		{
			ans.push_back(a[i]);
			i++;
		}
		else if (j < m && b[j] <= k)
		{
			ans.push_back(b[j]);
			j++;
		}
		else
		{
			cout << "-1" << endl;
			return;
		}
	}
	for (int i = 0; i < ans.size(); i++)
	{
		cout << ans[i] << " ";
	}
	cout << endl;

}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;

	while (t--)
	{
		solve();
	}
	return 0;
}
