#define __USE_MINGW_ANSI_STDIO 0
#include <bits/stdc++.h>

using namespace std;
using ll = long long;
// #define int ll
using VI = vector<int>;
using VVI = vector<VI>;
using PII = pair<int, int>;

#define FOR(i, a, n) for (ll i = (ll)a; i < (ll)n; ++i)
#define REP(i, n) FOR(i, 0, n)
#define ALL(x) x.begin(), x.end()
#define PB push_back

const ll LLINF = (1LL<<60);
const int INF = (1LL<<30);
const int MOD = 10000;

template <typename T> T &chmin(T &a, const T &b) { return a = min(a, b); }
template <typename T> T &chmax(T &a, const T &b) { return a = max(a, b); }
template <typename T> bool IN(T a, T b, T x) { return a<=x&&x<b; }
template<typename T> T ceil(T a, T b) { return a/b + !!(a%b); }
template<class S,class T>
ostream &operator <<(ostream& out,const pair<S,T>& a){
  out<<'('<<a.first<<','<<a.second<<')';
  return out;
}
template<class T>
ostream &operator <<(ostream& out,const vector<T>& a){
  out<<'[';
  REP(i, a.size()) {out<<a[i];if(i!=a.size()-1)out<<',';}
  out<<']';
  return out;
}

int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};

int dp[505][2][505][10][3][3];
signed main(void)
{
  cin.tie(0);
  ios::sync_with_stdio(false);

  string a, b;
  int m;
  cin >> a >> b >> m;

  int n = b.size();
  if(n != 1) {
    VI mo(n); mo[0] = 1%m;
    FOR(i, 1, n) mo[i] = mo[i-1]*10%m;
    // N以下の数を求める桁DP
    dp[0][0][0][0][0][0] = 1;
    REP(i, n) REP(j, 2) REP(k, m) REP(l, 10) REP(x, 3) REP(y, 3) {
      if(!dp[i][j][k][l][x][y]) continue;
      // cout << i << "," << j << "," << k << "," << l << "," << x << "," << y << " ";
      // cout << dp[i][j][k][l][x][y] << endl;
      int lim = j?9:b[i]-'0';
      REP(d, lim+1) {
        int cond = 0;
        if(y==1) {
          if(l < d) cond = 1;
          else if(l > d) cond = 2;
        } else if(x == 1) {
          if(l > d) cond = 2;
        } else if(x == 2) {
          if(l < d) cond = 1;
        }
        int cond2 = 0;
        if(y==0) {
          if(d) cond2 = 1;
        } else if(y==1) {
          cond2 = 2;
        } else {
          cond2 = 2;
        }
        (dp[i+1][j||d<lim][(k+mo[n-1-i]*d)%m][d][cond][cond2] += dp[i][j][k][l][x][y]) %= MOD;
      }
    }
  }

  int ans = 0;
  if(n != 1) {
    REP(i, 2) REP(j, 10) FOR(k, 1, 3) REP(l, 3) {
      if(!dp[n][i][0][j][k][l]) continue;
      // cout << n << "," << i << "," << 0 << "," << j << "," << k << "," << l << " ";
      // cout << dp[n][i][0][j][k][l] << endl;
      (ans += dp[n][i][0][j][k][l]) %= MOD;
    }
    REP(i, 9) {
      ans += (i+1)%m==0;
    }
  } else {
    REP(i, b[0]-'0') {
      ans += (i+1)%m==0;
    }
  }

  // cout << ans << endl;

  n = a.size();
  if(n != 1) {
    VI mo(n); mo[0] = 1%m;
    FOR(i, 1, n) mo[i] = mo[i-1]*10%m;
    // N以下の数を求める桁DP
    memset(dp, 0, sizeof(dp));
    dp[0][0][0][0][0][0] = 1;
    REP(i, n) REP(j, 2) REP(k, m) REP(l, 10) REP(x, 3) REP(y, 3) {
      if(!dp[i][j][k][l][x][y]) continue;
      // cout << i << "," << j << "," << k << "," << l << "," << x << "," << y << " ";
      // cout << dp[i][j][k][l][x][y] << endl;
      int lim = j?9:a[i]-'0';
      REP(d, lim+1) {
        int cond = 0;
        if(y==1) {
          if(l < d) cond = 1;
          else if(l > d) cond = 2;
        } else if(x == 1) {
          if(l > d) cond = 2;
        } else if(x == 2) {
          if(l < d) cond = 1;
        }
        int cond2 = 0;
        if(y==0) {
          if(d) cond2 = 1;
        } else if(y==1) {
          cond2 = 2;
        } else {
          cond2 = 2;
        }
        (dp[i+1][j||d<lim][(k+mo[n-1-i]*d)%m][d][cond][cond2] += dp[i][j][k][l][x][y]) %= MOD;
      }
    }
  }

  if(n != 1) {
    REP(i, 2) REP(j, 10) FOR(k, 1, 3) REP(l, 3) {
      if(!dp[n][i][0][j][k][l]) continue;
      // cout << n << "," << i << "," << 0 << "," << j << "," << k << "," << l << " ";
      // cout << dp[n][i][0][j][k][l] << endl;
      (ans -= dp[n][i][0][j][k][l] + MOD) %= MOD;
    }
    REP(i, 9) ans -= (i+1)%m==0;
    ans = (ans%MOD+MOD)%MOD;
  } else {
    REP(i, a[0]-'0') {
      ans -= (i+1)%m==0;
    }
  }

  // aがmの倍数かつジグザグ数ならansに+1する
  bool can = a[0]!=a[1];
  bool flag = a[0]<a[1];
  FOR(i, 2, n) {
    if(flag) {
      if(a[i-1]>a[i]) {
        flag = false;
      } else {
        can = false;
        break;
      }
    } else {
      if(a[i-1]<a[i]) {
        flag = true;
      } else {
        can = false;
        break;
      }
    }
  }
  int now = 0;
  for(int i=n-1; i>=0; --i) now = (now*10 + (a[i]-'0')) % m;
  if(now) can = false;
  if(can) ans++;

  cout << ans%MOD << endl;

  return 0;
}

