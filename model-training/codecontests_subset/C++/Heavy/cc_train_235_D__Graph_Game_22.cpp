#include <bits/stdc++.h>
#pragma GCC optimize("O2,Ofast,inline,unroll-all-loops,-ffast-math")
#pragma GCC target("popcnt")
using namespace std;
int stk[3010], n, top = 0;
long double ans = 0;
bool in[3010], loop[3010], found = false;
vector<int> nxt[3010];
vector<pair<int, int> > vec[3010];
template <class T>
void read(T &x) {
  char ch = x = 0;
  bool fl = false;
  while (!isdigit(ch)) fl |= ch == '-', ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x = fl ? -x : x;
}
void find_loop(int x, int fa) {
  if (found) return;
  if (in[x]) {
    loop[x] = true;
    while (stk[top] != x) {
      loop[stk[top--]] = true;
    }
    return found = true, void();
  }
  in[x] = true, stk[top++] = x;
  for (auto &v : nxt[x]) {
    if (v != fa) find_loop(v, x);
  }
  in[x] = false, top--;
}
void dfs(int x, int val, int dep) {
  if (loop[x] && !val) val = -dep;
  if (!loop[x] && val < 0) val += dep - 2;
  in[x] = true;
  vec[x].emplace_back(dep, val + (dep - 1) * loop[x]);
  for (auto &v : nxt[x]) {
    if (!in[v]) dfs(v, val, dep + 1);
  }
  in[x] = false;
}
int main() {
  cin >> n;
  for (int i = 1, u, v; i <= n; i++) {
    cin >> u >> v, nxt[++u].push_back(++v), nxt[v].push_back(u);
  }
  find_loop(1, 0);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      vec[j].clear();
    }
    dfs(i, 0, 1);
    for (int j = 1; j <= i; j++) {
      if (vec[j].size() == 1) {
        ans += 1.0 / vec[j][0].first * (j != i ? 2 : 1);
        continue;
      }
      int a = vec[j][0].second, b = vec[j][1].second,
          c = (vec[j][0].first + vec[j][1].first - a - b) / 2;
      ans += 2.0 * a / (a + b + c) / (b + c) + 2.0 * b / (a + b + c) / (a + c) +
             2.0 / (a + b + c);
    }
  }
  cout << fixed << setprecision(10) << ans << endl;
  return 0;
}
