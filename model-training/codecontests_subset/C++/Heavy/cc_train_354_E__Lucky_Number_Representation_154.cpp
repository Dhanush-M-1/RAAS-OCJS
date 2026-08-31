#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T __in() {
  T v;
  cin >> v;
  return v;
}
string num;
int dp[20][20];
int call(int p, int c) {
  if (p == ((int)num.size())) return c == 0;
  int &ret = dp[p][c];
  if (ret != -1) return ret;
  ret = 0;
  for (int f = 0; f <= 6; f++)
    for (int s = 0; s + f <= 6; s++) {
      int sum = (f)*4 + (s)*7 + c;
      if (sum % 10 == num[p] - '0')
        if (call(p + 1, sum / 10)) return ret = 1;
    }
  return ret;
}
void solve() {
  memset((dp), (-1), sizeof(dp));
  ;
  if (!call(0, 0)) {
    cout << -1 << endl;
    return;
  }
  int p = 0, c = 0;
  string ans[6];
  while (p < ((int)num.size())) {
    for (__typeof(7) f = 0; f < (7); f++) {
      int found = 0;
      for (int s = 0; s + f < 7; s++) {
        int sum = f * 4 + s * 7 + c;
        if (sum % 10 == num[p] - '0' && call(p + 1, sum / 10)) {
          found = 1;
          int k = 0;
          while (k < f) ans[k++] += '4';
          while (k < s + f) ans[k++] += '7';
          while (k < 6) ans[k++] += '0';
          c = sum / 10;
          p++;
          break;
        }
      }
      if (found) break;
    }
  }
  for (__typeof(6) i = 0; i < (6); i++) reverse(ans[i].begin(), ans[i].end());
  for (__typeof(6) i = 0; i < (6); i++) {
    if (i) cout << " ";
    int f = 0;
    for (__typeof(((int)ans[i].size())) j = 0; j < (((int)ans[i].size()));
         j++) {
      if (ans[i][j] != '0') f = 1;
      if (f) cout << ans[i][j];
    }
    if (!f) cout << 0;
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  int test;
  cin >> test;
  while (test--) {
    cin >> num;
    reverse(num.begin(), num.end());
    solve();
  }
  return 0;
}
