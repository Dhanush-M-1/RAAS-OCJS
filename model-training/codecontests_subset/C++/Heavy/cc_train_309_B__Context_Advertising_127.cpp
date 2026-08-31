#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000100;
int n, r, c, l[maxn], sum[maxn];
string word[maxn];
int last[maxn][25], ans[maxn];
int main() {
  std::ios::sync_with_stdio(false);
  cin >> n >> r >> c;
  cin.get();
  sum[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> word[i];
    l[i] = word[i].size();
    sum[i] = sum[i - 1] + l[i];
  }
  cin.get();
  int p = 0;
  memset(last, 0, sizeof(last));
  for (int i = 1; i <= n; i++) {
    if (l[i] > c) {
      p = i;
      continue;
    }
    while (p + 1 <= n && sum[p + 1] - sum[i - 1] + p + 1 - i <= c) p++;
    last[i][0] = p;
  }
  for (int i = n; i >= 1; i--) {
    for (int j = 1; j <= 20; j++)
      if (last[i][j - 1] != 0) {
        if (last[i][j - 1] == n)
          last[i][j] = n;
        else if (last[last[i][j - 1] + 1][j - 1] != 0)
          last[i][j] = last[last[i][j - 1] + 1][j - 1];
        else
          last[i][j] = last[i][j - 1];
      }
  }
  for (int i = 1; i <= n; i++) {
    int now = i;
    for (int j = 20; j >= 0; j--)
      if (((r >> j) & 1) && now != n + 1 && last[now][j] != 0)
        now = last[now][j] + 1;
    now--;
    ans[i] = now;
  }
  int ax = 0;
  ans[0] = -10000;
  for (int i = 1; i <= n; i++)
    if (ans[i] - i + 1 > ans[ax] - ax + 1) ax = i;
  int now = ax, cnt = 1;
  while (cnt <= r) {
    if (last[now][0] != 0 && now != n + 1) {
      for (int i = now; i < last[now][0]; i++) cout << word[i] << " ";
      cout << word[last[now][0]] << endl;
      now = last[now][0] + 1;
    } else
      cout << endl;
    cnt++;
  }
  return 0;
}
