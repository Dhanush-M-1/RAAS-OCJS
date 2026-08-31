#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int sum = 0, ff = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') ff = -1;
    ch = getchar();
  }
  while (isdigit(ch)) sum = sum * 10 + (ch ^ 48), ch = getchar();
  return sum * ff;
}
const int mod = 1e9 + 7;
const int mo = 998244353;
const int N = 2e5 + 5;
int n, m, s, du[N], ok[N], ux[N], uy[N], sum[N], cnt, ans;
vector<int> G[N];
inline void del(int x) {
  queue<int> q;
  q.push(x);
  ans--;
  ok[x] = 1;
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int i = (0); i <= ((int)G[u].size() - 1); i++) {
      int v = G[u][i];
      if (ok[v]) continue;
      if ((--du[v]) < s) q.push(v), ok[v] = 1, ans--;
    }
  }
}
int main() {
  n = read();
  m = read();
  s = read();
  for (int i = (1); i <= (m); i++) {
    int x, y;
    x = read(), y = read();
    G[x].push_back(y);
    G[y].push_back(x);
    du[y]++, du[x]++;
    ux[i] = x, uy[i] = y;
  }
  ans = n;
  for (int i = (1); i <= (n); i++)
    if (!ok[i] && du[i] < s) del(i);
  sum[m] = ans;
  for (int i = (m); i >= (1); i--) {
    int x = ux[i], y = uy[i];
    if (!ok[x]) du[y]--;
    if (!ok[y]) du[x]--;
    G[x].pop_back();
    G[y].pop_back();
    if (!ok[x] && du[x] < s) del(x);
    if (!ok[y] && du[y] < s) del(y);
    sum[i - 1] = ans;
  }
  for (int i = (1); i <= (m); i++) printf("%d\n", sum[i]);
  return 0;
}
