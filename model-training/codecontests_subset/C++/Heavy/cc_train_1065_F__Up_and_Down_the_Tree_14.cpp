#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0;
  char ch = getchar();
  bool d = 1;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') d = 0;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  return d ? x : -x;
}
inline unsigned long long rnd() {
  return ((unsigned long long)rand() << 30 ^ rand()) << 4 | rand() % 4;
}
const int N = 1e6 + 5;
int n, m, mn[N], f[N][2], dep[N];
vector<long long> v[N];
void dfs(int u, int fa) {
  mn[u] = 0x3f3f3f3f;
  int sum = 0, cnt = 0;
  for (auto k : v[u]) {
    cnt++;
    dep[k] = dep[u] + 1;
    dfs(k, u);
    if (mn[k] - m <= dep[u]) sum += f[k][0];
    mn[u] = min(mn[u], mn[k]);
  }
  if (!cnt) {
    mn[u] = dep[u];
    f[u][0] = f[u][1] = 1;
    return;
  }
  f[u][0] = sum;
  for (auto k : v[u]) {
    int t = f[k][0];
    if (mn[k] - m > dep[u]) t = 0;
    f[u][1] = max(f[u][1], sum - t + f[k][1]);
  }
}
int main() {
  n = read();
  m = read();
  for (int i = (int)(2); i <= (int)(n); i++) v[read()].push_back(i);
  dfs(1, 0);
  cout << max(f[1][0], f[1][1]);
}
