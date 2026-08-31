#include <bits/stdc++.h>
using namespace std;
// ==================================================
using i64 = int64_t; using u64 = uint64_t;
#define rep(i,a,b) for(i64 i=(i64)(a);i<(i64)(b);i++)
#define repn(i,n) rep(i,0,n)
#define din(t, ...) t __VA_ARGS__;_din(__VA_ARGS__)
#define stlv(t,n) vector<t> n
#define stls(t,n) set<t> n
void _din() {} void dout() { cout << endl; }
template <typename T, typename ... Args> inline void _din(T& head, Args& ... rest) { cin >> head; _din(rest...); }
template <typename T, typename ... Args> inline void dout(T head, Args ... rest) { cout << head; if (sizeof...(rest)) cout << ' '; dout(rest...); }
template <typename T>inline void vsortg(vector<T>& v) { sort(v.begin(), v.end(), greater<T>()); }
template <typename T>inline void vsortl(vector<T>& v) { sort(v.begin(), v.end(), less<T>()); }
template <typename T> inline T nmax(T f1, T f2) { return max(f1, f2); }
template <typename T, typename ... Args> inline T nmax(T first, Args ... rest) { return nmax(first, nmax(rest...)); }
template <typename T> inline T nmin(T f1, T f2) { return min(f1, f2); }
template <typename T, typename ... Args> inline T nmin(T first, Args ... rest) { return nmin(first, nmin(rest...)); }

int main()
{
	din(i64, n);
	stlv(i64, v(n));

	repn(i, n)
	{
		din(, v[i]);
	}
	vsortl(v);
	i64 st = 0;
	for (;;)
	{
		for (int i = st + 1; i < n; i++)
		{
			if ((v[i] - v[st]) % (n - 1) == 0)
			{
				dout(v[i], v[st]);
				return 0;
			}
		}
		if (st + 1 < n) st++;
		else

			break;
	}
	return 0;
}
