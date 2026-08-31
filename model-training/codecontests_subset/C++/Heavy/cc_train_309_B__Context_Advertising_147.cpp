#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 7;
const int maxn = 1e6 + 5;
const int logn = 21;
int n, c, r, ans;
int l[maxn], res[maxn], sum[maxn];
int st[maxn][logn];
string s[maxn];
int main() {
  cin >> n >> r >> c;
  for (int i = (0); i < (n); ++i) cin >> s[i], l[i] = s[i].size();
  for (int i = (0); i < (n); ++i) sum[i] = l[i] + (i ? sum[i - 1] + 1 : 0);
  for (int i = (0); i < (n); ++i) {
    int &pos = st[i][0];
    pos = upper_bound(sum, sum + n, (i ? (sum[i - 1] + 1) : 0) + c) - sum;
    pos = max(pos, i);
  }
  for (int j = (1); j < (logn); ++j)
    for (int i = (0); i < (n); ++i) {
      if (st[i][j - 1] == n)
        st[i][j] = n;
      else {
        st[i][j] = st[st[i][j - 1]][j - 1];
      }
    }
  st[n][0] = n;
  for (int i = (0); i < (n); ++i) {
    int j = i;
    for (int k = logn - 1; k >= 0; --k)
      if (r >> k & 1) {
        j = st[j][k];
        if (j == n) break;
      }
    ans = max(ans, j - i);
    res[i] = j;
  }
  for (int i = (0); i < (n); ++i)
    if (res[i] - i == ans) {
      int len = 0;
      for (int j = (i); j < (res[i]); ++j) {
        if (j == i) {
          cout << s[j];
          len += l[j];
          continue;
        }
        if (len + l[j] + 1 > c) {
          puts("");
          cout << s[j];
          len = l[j];
        } else {
          cout << " " << s[j];
          len += l[j] + 1;
        }
      }
      return 0;
    }
  return 0;
}
