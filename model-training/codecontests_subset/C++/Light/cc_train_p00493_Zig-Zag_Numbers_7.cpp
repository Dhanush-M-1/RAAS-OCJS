#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <climits>
#include <cfloat>
#include <ctime>
#include <cassert>
#include <map>
#include <utility>
#include <set>
#include <iostream>
#include <memory>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <sstream>
#include <complex>
#include <stack>
#include <queue>
#include <numeric>
#include <list>


using namespace std;

#ifdef _MSC_VER
#define __typeof__ decltype
template <class T> int __builtin_popcount(T n) { return n ? 1 + __builtin_popcount(n & (n - 1)) : 0; }
#endif

#define foreach(it, c) for (__typeof__((c).begin()) it=(c).begin(); it != (c).end(); ++it)
#define all(c) (c).begin(), (c).end()
#define rall(c) (c).rbegin(), (c).rend()
#define CLEAR(arr, val) memset(arr, val, sizeof(arr))

#define rep(i, n) for (int i = 0; i < n; ++i)

template <class T> void max_swap(T& a, const T& b) { a = max(a, b); }
template <class T> void min_swap(T& a, const T& b) { a = min(a, b); }

typedef long long ll;
typedef pair<int, int> pint;

const double EPS = 1e-8;
const double PI = acos(-1.0);
const int dx[] = { 0, 1, 0, -1 };
const int dy[] = { 1, 0, -1, 0 };



const int mod = 10000;
int m;

int rem[512][10];
int incr[512][512][10], decr[512][512][10];
void dpru(int digits)
{
	for (int i = 0; i < 10; ++i)
		rem[0][i] = i;
	for (int i = 0; i < digits; ++i)
		for (int j = 0; j < 10; ++j)
			rem[i + 1][j] = (rem[i][j] * 10) % m;

	for (int i = 0; i < 10; ++i)
		incr[0][i % m][i] = decr[0][i % m][i] = 1;

	for (int i = 0; i < digits; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			for (int k = 0; k < 10; ++k)
			{
				for (int l = 0; l < 10; ++l)
				{
					int r = (j + rem[i + 1][l]) % m;
					if (l > k)
						(incr[i + 1][r][l] += decr[i][j][k]) %= mod;
					else if (l < k)
						(decr[i + 1][r][l] += incr[i][j][k]) %= mod;
				}
			}
		}
	}
}
bool zig_zag(int n)
{
	vector<int> v;
	for (int i = n; i; i /= 10)
		v.push_back(i % 10);
	for (int i = 1; i < v.size(); ++i)
		if (v[i - 1] == v[i])
			return false;
	for (int i = 2; i < v.size(); ++i)
		if (v[i - 2] < v[i - 1] && v[i - 1] < v[i]
			|| v[i - 2] > v[i - 1] && v[i - 1] > v[i])
			return false;
	return true;
}
vector<int> zig_zag_simple(int n)
{
	vector<int> res;
	for (int i = 1; i <= n; ++i)
		if (i % m == 0 && zig_zag(i))
			res.push_back(i);
	return res;
}
int zig_zag_eq_less(const string& s)
{
	const int n = s.size();
	if (n <= 3)
		return zig_zag_simple(atoi(s.c_str())).size();

	vector<int> d(n);
	for (int i = 0; i < n; ++i)
		d[i] = s[n-1 - i] - '0';

	int res = zig_zag_simple(99).size();

	for (int digits = 2; digits < n - 1; ++digits)
		for (int i = 1; i < 10; ++i)
			(res += incr[digits][0][i] + decr[digits][0][i]) %= mod;

	for (int i = 1; i < d[n - 1]; ++i)
	{
		int r = (m - rem[n - 1][i]) % m;
		for (int j = 0; j < 10; ++j)
		{
			if (i < j)
				(res += incr[n - 2][r][j]) %= mod;
			else if (i > j)
				(res += decr[n - 2][r][j]) %= mod;
		}
	}

	int rr = rem[n - 1][d[n - 1]];
	for (int i = 0; i < d[n - 2]; ++i)
	{
		int r = (m - rr) % m;
		if (d[n - 1] < i)
			(res += incr[n - 2][r][i]) %= mod;
		else if (d[n - 1] > i)
			(res += decr[n - 2][r][i]) %= mod;
	}
	if (d[n - 2] == d[n - 1])
		return res;

	(rr += rem[n - 2][d[n - 2]]) %= m;
	bool inc = d[n - 1] > d[n - 2];
	for (int i = n - 3; i >= 0; --i)
	{
		if (inc)
		{
			for (int j = d[i + 1] + 1; j < d[i]; ++j)
				(res += incr[i][(m - rr) % m][j]) %= mod;
		}
		else
		{
			for (int j = 0; j < min(d[i], d[i + 1]); ++j)
				(res += decr[i][(m - rr) % m][j]) %= mod;
		}

		if (inc ^ (d[i + 1] < d[i]))
			break;

		(rr += rem[i][d[i]]) %= m;
		inc ^= true;
		if (i == 0 && rr == 0)
			++res;
	}

	return res;
}
string decrement(const string& n)
{
	string res = n;
	for (int i = res.size() - 1; i >= 0; --i)
	{
		if (res[i] == '0')
			res[i] = '9';
		else
		{
			--res[i];
			break;
		}
	}
	if (res[0] == '0')
		res.erase(0, 1);
	return res;
}
int main()
{
	string a, b;
	cin >> a >> b >> m;
	int digits = b.size();
	dpru(digits);

	int y = zig_zag_eq_less(b);
	int x = zig_zag_eq_less(decrement(a));

	cout << (y - x + mod) % mod << endl;

	//m = 3;
	//dpru(100);
	//int S = 11000000;
	//int R = 1;
	//for(;;)
	//{
	//cin >> S;
	//for (int i = S; i < S + R; ++i)
	//{
	//	vector<int> z = zig_zag_simple(i);
	//	stringstream ss;
	//	ss << i;

	//	int cor = z.size();
	//	int my = zig_zag_eq_less(ss.str());
	//	//if (cor != my)
	//		printf("%4d: %3d, %3d\n", i, cor, my);
	//}
	//}
}