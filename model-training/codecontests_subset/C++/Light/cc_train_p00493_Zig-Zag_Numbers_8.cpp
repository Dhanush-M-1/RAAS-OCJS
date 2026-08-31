#include <bits/stdc++.h>

using namespace std;

#define all(v) begin(v), end(v)
#define rep(i, n) for(int i = 0; i < (int)(n); i++)
#define reps(i, s, n) for(int i = (int)(s); i < (int)(n); i++)

const int mod = 10000;

string A, B;
int M;

// dp[index][islower][mod][zig-zag][prev]
int dp[501][2][500][3][10];

int solve(const string& s, int idx, int lt, int m, int zg, int prev)
{
  if(idx == s.size()) return m == 0;

  int& ret = dp[idx][lt][m][zg][prev];
  if(~ret) return ret;

  ret = 0;
  int lim = lt ? 9 : s[idx]-'0';
  rep(d, lim + 1) {
    int zgzg = -1;
    if(zg == 0) { // start
      if(prev == 0) zgzg = 0;
      else if(d == prev) continue;
      else if(d < prev) zgzg = 1;
      else if(d > prev) zgzg = 2;
    } else if(zg == 1) { // up
      if(d <= prev) continue;
      else zgzg = 2;
    } else if(zg == 2) { // down
      if(d >= prev) continue;
      else zgzg = 1;
    }
    assert(zgzg != -1);
    (ret += solve(s, idx+1, lt||d<lim, (m*10+d)%M, zgzg, d)) %= mod;
  }

  return ret % mod;
}

signed main()
{
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cout << fixed << setprecision(12);

  cin >> A >> B >> M;

  for(int i = (int)A.size()-1; i >= 0; i--) {
    if(A[i] == '0') {
      A[i] = '9';
    } else {
      A[i]--;
      break;
    }
  }

  memset(dp, -1, sizeof(dp));
  int a = solve(A, 0, 0, 0, 0, 0);
  memset(dp, -1, sizeof(dp));
  int b = solve(B, 0, 0, 0, 0, 0);

  cout << (b - a + mod) % mod << endl;

  return 0;
}