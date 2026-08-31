#include <iostream>
#include <iomanip>
#include <sstream>
#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
#include <complex>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <cassert>
#include <climits>
#include <queue>
#include <set>
#include <map>
#include <valarray>
#include <bitset>
#include <stack>
using namespace std;

#define REP(i,n) for(int i=0;i<(int)n;++i)
#define FOR(i,c) for(__typeof((c).begin())i=(c).begin();i!=(c).end();++i)
#define ALL(c) (c).begin(), (c).end()
typedef long long ll;
typedef pair<int,int> pii;
const int INF = 1<<29;
const double PI = acos(-1);
const double EPS = 1e-8;
int MOD = 10000;
int dp[501][10][500][2][2];
string str;
int n;
int M;
int rec(int pos, int pre, int q, bool up, bool smaller) {
  if (pos == n) return q==0;
  if (dp[pos][pre][q][up][smaller] >= 0) return dp[pos][pre][q][up][smaller];
  int res = 0;
  int s = str[pos]-'0';
  int lb, ub;
  if (up) lb = 0, ub = pre-1;
  else lb = pre+1, ub = 9;
  if (!smaller) ub = min(ub, s);
  //cout << pos << " " << pre << " " <<lb << " " << ub << endl;
  for (int i=lb; i<=ub; ++i) {
    res = (res + rec(pos+1, i, (q*10+i)%M, !up, i<s?1:smaller)) % MOD;
  }
  return dp[pos][pre][q][up][smaller] = res;
}

int solve(string s) {
  n = s.size();
  str = s;
  memset(dp, -1, sizeof(dp));
  int res = 0;
  for (int i=1; i<=s[0]-'0'; ++i) {
    if (n>=2) res = (res + rec(1,i,i%M,0,s[0]-'0'!=i)) % MOD;
    res = (res + rec(1,i,i%M,1,s[0]-'0'!=i)) % MOD;
  }
  for (int i=1; i<n; ++i) {
    for (int j=1; j<=9; ++j) {
      if (i!=n-1) res = (res + rec(i+1,j,j%M,0,1)) % MOD;
       // // cout << i << " "<< j << endl;
       // // cout << res << endl;
      res = (res + rec(i+1,j,j%M,1,1)) % MOD;
    }
  }
  return res;
}

string minus1(string s) {
  int c = 1;
  for (int i=s.size()-1; i>=0; --i) {
    if (s[i] == '0') s[i] = '9';
    else {
      s[i]--;
      break;
    }
  }
  return s;
}
int main() {
  string A, B;
  cin >> A >> B;
  cin >> M;
  //M = 5;
  //cout << solve("0") << endl;
  cout << (solve(B)-solve(minus1(A)) + MOD) % MOD << endl;
}