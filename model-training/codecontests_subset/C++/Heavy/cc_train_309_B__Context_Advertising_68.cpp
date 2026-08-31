#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000 * 1000 + 100;
int n, r, c;
string s[maxn];
int len[maxn];
int dp[maxn][22];
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> r >> c;
  c++;
  for (int i = 0, _n = (int)(n); i < _n; i++) {
    cin >> s[i];
    len[i] = (int((s[i]).size())) + 1;
  }
  int tot = 0, end = n;
  for (int j = 0, _n = (int)(22); j < _n; j++) dp[n][j] = n;
  for (int i = (int)(n), _x = (int)(0); i-- > _x;) {
    tot += len[i];
    while (tot > c) tot -= len[--end];
    dp[i][0] = end;
    for (int j = (int)(1), _n = (int)(22); j < _n; j++)
      dp[i][j] = dp[dp[i][j - 1]][j - 1];
  }
  int mx = -1, start = 0;
  for (int i = 0, _n = (int)(n); i < _n; i++) {
    int rr = r;
    int end = i;
    for (int j = 0, _n = (int)(22); j < _n; j++) {
      if (rr & 1) end = dp[end][j];
      rr /= 2;
    }
    if (end - i > mx) mx = end - i, start = i;
  }
  int now = c + 1, dt = 0;
  for (int i = (int)(start), _n = (int)(start + mx); i < _n; i++) {
    if (now + len[i] > c) {
      now = 0;
      if (dt) cout << endl;
    } else
      cout << " ";
    now += len[i];
    dt = 1;
    cout << s[i];
  }
  cout << endl;
  {
    int _;
    cin >> _;
    return 0;
  }
}
