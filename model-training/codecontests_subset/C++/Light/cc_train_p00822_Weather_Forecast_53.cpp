#include <bits/stdc++.h>
using namespace std;
#define FOR(i,k,n) for(int i = (int)(k); i < (int)(n); i++)
#define REP(i,n) FOR(i,0,n)
#define ALL(a) a.begin(), a.end()
#define MS(m,v) memset(m,v,sizeof(m))
#define D10 fixed<<setprecision(10)
typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef vector<string> vs;
typedef pair<int, int> pii;
const int MOD = 1000000007;
const int INF = MOD + 1;
const ld EPS = 1e-12;
template<class T> T &chmin(T &a, const T &b) { return a = min(a, b); }
template<class T> T &chmax(T &a, const T &b) { return a = max(a, b); }

/*--------------------template--------------------*/
int n;
vector<vi> v;
short dp[366][10][8][8][8][8];

vi move(int t)
{
	vi res;
	if (t == 0) res = { 0,1,2,3,6 };
	if (t == 1) res = { 0,1,2,4,7 };
	if (t == 2) res = { 0,1,2,5,8 };
	if (t == 3) res = { 3,4,5,0,6 };
	if (t == 4) res = { 3,4,5,1,7 };
	if (t == 5) res = { 3,4,5,2,8 };
	if (t == 6) res = { 6,7,8,0,3 };
	if (t == 7) res = { 6,7,8,1,4 };
	if (t == 8) res = { 6,7,8,2,5 };
	return res;
}

vi range(int t)
{
	vi res;
	if(t<3) res = { t, t + 1,t + 4,t + 5 };
	else if (t < 6) res = { t + 1,t + 2,t + 5,t + 6 };
	else res = { t + 2,t + 3,t + 6,t + 7 };
	return res;
}

short solve(const int day, const int pos, const int ul, const int ur, const int dl, const int dr)
{
	if (dp[day][pos][ul][ur][dl][dr] >= 0) return dp[day][pos][ul][ur][dl][dr];
	if (ul == 7 || ur == 7 || dl == 7 || dr == 7)  return 0;
	if (day == n - 1) return 1;
	short res = 0;
	vi can = move(pos);
	REP(i, can.size())
	{
		int npos = can[i];
		vi rain = range(npos);
		bool f = false;
		REP(j, rain.size()) if (v[day + 1][rain[j]]) f = true;
		if (f) continue;
		int nul = ul + 1, nur = ur + 1, ndl = dl + 1, ndr = dr + 1;
		if (npos == 0) nul = 0;
		if (npos == 2) nur = 0;
		if (npos == 6) ndl = 0;
		if (npos == 8) ndr = 0;
		if (solve(day + 1, npos, nul, nur, ndl, ndr)) res = 1;
	}
	return dp[day][pos][ul][ur][dl][dr] = res;
}

int main()
{
	while (cin >> n, n)
	{
		MS(dp, -1);
		v.clear();
		v.resize(n, vi(16));
		REP(i, n)REP(j, 16) cin >> v[i][j];

		bool f = true;
		vi a = { 5,6,9,10 };
		REP(i, 4) if (v[0][a[i]]) f = false;
		if (!f) puts("0");
		else puts(solve(0, 4, 1, 1, 1, 1) == 1 ? "1" : "0");
	}
	return 0;
}