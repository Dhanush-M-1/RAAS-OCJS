#include <bits/stdc++.h>
using namespace std;
int n, r, c;
string s[1 << 20];
char a[1 << 23];
int sum[1 << 20], nxt[1 << 20][25];
int main() {
  cin >> n >> r >> c;
  ++c;
  sum[0] = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%s", a);
    s[i] = a;
    sum[i] = sum[i - 1] + s[i].size() + 1;
  }
  for (int i = 1; i <= n; ++i) {
    nxt[i][0] = upper_bound(sum + 1, sum + n + 1, sum[i - 1] + c) - sum;
  }
  nxt[n + 1][0] = n + 1;
  for (int j = 1; j < 25; ++j) {
    for (int i = 1; i <= n; ++i) nxt[i][j] = nxt[nxt[i][j - 1]][j - 1];
    nxt[n + 1][j] = n + 1;
  }
  int mx = 0, pos = 0;
  for (int i = 1; i <= n; ++i) {
    int nx = i;
    for (int j = 25; j >= 0; --j) {
      if (r & (1 << j)) nx = nxt[nx][j];
    }
    if (mx < nx - i) {
      mx = nx - i;
      pos = i;
    }
  }
  for (int i = 0; i < r && pos <= n; ++i) {
    for (int j = pos; j < nxt[pos][0]; ++j) {
      for (int k = 0; k < s[j].size(); ++k) printf("%c", s[j][k]);
      if (j != nxt[pos][0] - 1) printf(" ");
    }
    if (pos == nxt[pos][0]) break;
    pos = nxt[pos][0];
    if (pos == n + 1) break;
    printf("\n");
  }
}
