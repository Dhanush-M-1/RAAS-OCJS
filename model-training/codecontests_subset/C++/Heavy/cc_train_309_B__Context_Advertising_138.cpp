#include <bits/stdc++.h>
using namespace std;
const int N = 1000004, M = 20;
int nxt[N][M], s[N], r, c, n;
string t[N];
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> r >> c;
  for (int i = 1; i <= n; i++) {
    cin >> t[i];
    s[i] = s[i - 1] + t[i].size();
  }
  for (int j = 0; j < M; j++) nxt[n + 1][j] = n + 1;
  for (int i = 1, j = -1; i <= n; i++) {
    if (j < i) j = i;
    for (; j <= n && s[j] - s[i - 1] + j - i <= c; ++j)
      ;
    nxt[i][0] = j;
  }
  for (int i = n; i >= 1; i--)
    for (int j = 1; j < M; j++) nxt[i][j] = nxt[nxt[i][j - 1]][j - 1];
  int sum = 0, p = 0, q = 0;
  for (int i = 1, j; i <= n; i++) {
    j = i;
    for (int k = 0; k < M; k++)
      if (r >> k & 1) j = nxt[j][k];
    if (j - i > sum) sum = j - i, p = i, q = j;
    if (j == n + 1) break;
  }
  for (int i = p; i != q; i = nxt[i][0]) {
    for (int j = i; j < nxt[i][0]; j++)
      cout << t[j] << " \n"[j + 1 == nxt[i][0]];
  }
}
