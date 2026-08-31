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

// dp[i][j][pre][eq or low][up or down or first]
int dp[2][500][10][2][3];
const int mod = 10000;

inline void add(int &a, int b) {
  a = (a+b) % mod;
}

int solve(const string &s, int m) {
  memset(dp,0,sizeof(dp));
  REP(i,s.size()) {
    int now = i&1;
    int nxt = (i+1)&1;
    REP(j,m)REP(pre,10)REP(low,2)REP(up,3) dp[nxt][j][pre][low][up]=0;
    REP(j,m) {
      REP(pre,10) {
        REP(k,10) {
          // first digit
          if (k>0 && (i!=0 || k<=s[i]-'0')) {
            bool eqlow = 1;
            if (i==0 && k==s[i]-'0') eqlow = 0;
            dp[nxt][k%m][k][eqlow][2] = 1;
          }
          // other
          if (k<pre) {
            add(dp[nxt][(j*10+k)%m][k][1][1], dp[now][j][pre][1][0]);
            add(dp[nxt][(j*10+k)%m][k][1][1], dp[now][j][pre][1][2]);
            if (k<=s[i]-'0') {
              add(dp[nxt][(j*10+k)%m][k][k!=s[i]-'0'][1], dp[now][j][pre][0][0]);
              add(dp[nxt][(j*10+k)%m][k][k!=s[i]-'0'][1], dp[now][j][pre][0][2]);
            }
          }
          if (k>pre) {
            add(dp[nxt][(j*10+k)%m][k][1][0], dp[now][j][pre][1][1]);
            add(dp[nxt][(j*10+k)%m][k][1][0], dp[now][j][pre][1][2]);
            if (k<=s[i]-'0') {
              add(dp[nxt][(j*10+k)%m][k][k!=s[i]-'0'][0], dp[now][j][pre][0][1]);
              add(dp[nxt][(j*10+k)%m][k][k!=s[i]-'0'][0], dp[now][j][pre][0][2]);
            }
          }
        }
      }
    }
  }
  int ans = 0;
  REP(pre,10) {
    REP(low,2) {
      REP(up,3) {
        // if (dp[s.size()&1][0][pre][low][up]) {
        //   cout << pre << " " << low << " "<< up << endl;
        // }
        add(ans, dp[s.size()&1][0][pre][low][up]);
      }
    }
  }
  return ans;
}

string sub1(string s) {
  for (int i=s.size()-1; i>=0; --i) {
    if (s[i]-'0'-1 < 0) {
      s[i] = '9';
    } else {
      s[i] -= 1;
      return s;
    }
  }
  return s;
}

int main() {
  
  string a, b;
  cin >> a >> b;
  int m;cin >> m;
  // cout << solve(sub1("1"), 1) << endl;
  // cout << solve(string("10"),2) << endl;
  cout << (solve(b,m)-solve(sub1(a),m)+mod)%mod << endl;
}