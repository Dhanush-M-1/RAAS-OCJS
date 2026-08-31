#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <ctime>
#include <cassert>
#include <iostream>
#include <cctype>
#include <sstream>
#include <string>
#include <list>
#include <vector>
#include <queue>
#include <set>
#include <stack>
#include <map>
#include <utility>
#include <numeric>
#include <algorithm>
#include <iterator>
#include <bitset>
#include <complex>
#include <fstream>
using namespace std;
typedef long long ll;
const double EPS = 1e-9;
typedef vector<int> vint;
typedef pair<int, int> pint;
#define rep(i, n) REP(i, 0, n)
#define ALL(v) v.begin(), v.end()
#define MSG(a) cout << #a << " " << a << endl;
#define REP(i, x, n) for(int i = x; i < n; i++)
template<class T> T RoundOff(T a){ return int(a+.5-(a<0)); }
template<class T, class C> void chmax(T& a, C b){ if(a < b) a = b; }
template<class T, class C> void chmin(T& a, C b){ if(b < a) a = b; }
template<class T, class C> pair<T, C> mp(T a, C b){ return make_pair(a, b); }

const int MOD = 10000;
int memo[501][10][2][2][501];
string A, B;
int M;


// x*10^nをvで割った時の余り
int calc_rest(int x, int n, int v)
{
	for(int i = 0; i < n; i++)
	{
		x -= (x / v) * v;
		x *= 10;
	}
	
	return x / 10;
}

// 数値列をディクリメントする
string dec(string S)
{
	for(int i = S.size() - 1; 0 <= i; i--)
	{
		if(S[i] != '0')
		{
			S[i]--;
			if(S[i] == '0' && i == 0 && 1 < S.size()) S = S.substr(1);
			return S;
		}
		else S[i] = '9';
	}
	
	return S;
}

// S=対象の文字列, pnt=着目している文字の場所, prv=直前の文字, ul=数字は増えるか, sp=既に最大の数より小さいことが決まっているか, rest=累積の余り, zero=最初であり0が禁止されているか
int rec(string &S, int pnt, int prv, bool inc, bool sp, int rest, bool zero)
{
	if(pnt == S.size())	return rest == 0;
	
	if(!zero && memo[pnt][prv][inc][sp][rest] != -1) return memo[pnt][prv][inc][sp][rest];
	
	int dig = S.size() - pnt;
	ll res = 0;
	
	if(inc)
	{
		int lim = (sp ? 10 : S[pnt] - '0' + 1);
		for(int i = prv + 1; i < lim; i++)
		{
			res += rec(S, pnt + 1, i, false, sp || i < S[pnt] - '0', (rest * 10 + i) % M, false);
			res %= MOD;
		}
	}
	else
	{
		for(int i = (sp ? prv - 1 : min(prv - 1, S[pnt] - '0')); zero <= i; i--)
		{
			res += rec(S, pnt + 1, i, true, sp || i < S[pnt] - '0', (rest * 10 + i) % M, false);
			res %= MOD;
		}
	}
	
	return zero ? res : memo[pnt][prv][inc][sp][rest] = res;
}

// S以下のZigZagNumberを数える
int count(string &S)
{
	if(S.size() == 1) return (S[0] - '0') / M;
	
	memset(memo, -1, sizeof memo);
	
	ll res = 9 / M;

	for(int i = 1; i < S.size(); i++)
	{
		int inc = rec(S, S.size() - i - 1, 0, true, i != S.size() - 1, 0, true);
		int fal = rec(S, S.size() - i - 1, (i == S.size() - 1 ? S[0] - '0' + 1 : 10), false, i != S.size() - 1, 0, true);
		
		res += inc + fal;
		res %= MOD;
	}
	
	return res;
}


int solve()
{
	A = dec(A);
	return (count(B) - count(A) + MOD) % MOD;
}


int main()
{
	cin >> A >> B >> M;
	cout << solve() << endl;
}