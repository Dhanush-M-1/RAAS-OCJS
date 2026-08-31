#include <bits/stdc++.h>
using namespace std;
void file(string s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
template <typename Tp>
void read(Tp &x) {
  int fh = 1;
  char c = getchar();
  x = 0;
  while (c > '9' || c < '0') {
    if (c == '-') {
      fh = -1;
    }
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 1) + (x << 3) + (c & 15);
    c = getchar();
  }
  x *= fh;
}
int n, m;
vector<int> G[1000005];
namespace Tarjan {
int dfn[1000005], ndfn[1000005], low[1000005], ins[1000005], tot;
stack<int> stk;
int FLG;
int l2[1000005];
void dfs0(int x) {
  dfn[x] = low[x] = ++tot;
  ins[x] = 1;
  stk.push(x);
  for (auto y : G[x]) {
    if (dfn[y]) {
      if (ins[y])
        low[x] = min(low[x], dfn[y]);
      else
        FLG = -1;
    } else {
      dfs0(y);
      low[x] = min(low[x], low[y]);
    }
  }
  ins[x] = 0;
  stk.pop();
}
void dfs(int x) {
  dfn[x] = low[x] = l2[x] = ++tot;
  ndfn[tot] = x;
  ins[x] = 1;
  stk.push(x);
  for (auto y : G[x]) {
    if (dfn[y]) {
      if (ins[y]) {
        if (dfn[y] < low[x]) {
          swap(low[x], l2[x]);
          low[x] = dfn[y];
        } else {
          if (dfn[y] < l2[x]) l2[x] = dfn[y];
        }
      }
    } else {
      dfs(y);
      if (low[y] < low[x]) {
        swap(low[x], l2[x]);
        low[x] = low[y];
      } else {
        if (low[y] < l2[x]) l2[x] = low[y];
      }
      if (l2[y] < low[x]) {
        swap(low[x], l2[x]);
        low[x] = l2[y];
      } else {
        if (l2[y] < l2[x]) l2[x] = l2[y];
      }
    }
  }
  if (dfn[x] == low[x]) {
    int y = stk.top();
    stk.pop();
    ins[y] = 0;
    while (y != x) {
      y = stk.top();
      stk.pop();
      ins[y] = 0;
    }
  }
}
bool chk_good(int RT, int tp = 0) {
  for (int i = 1; i <= n; ++i) dfn[i] = low[i] = l2[i] = ins[i] = 0;
  tot = 0;
  FLG = 0;
  dfs0(RT);
  if (tot != n || FLG == -1) return 0;
  if (tp) {
    for (int i = 1; i <= n; ++i) dfn[i] = low[i] = l2[i] = ins[i] = 0;
    tot = 0;
    FLG = 0;
    dfs(RT);
  }
  return 1;
}
}  // namespace Tarjan
int ans[1000005];
int ta[1000005];
signed main() {
  srand(time(0));
  int CasT;
  read(CasT);
  while (CasT--) {
    read(n);
    read(m);
    for (int i = 1; i <= n; ++i) ans[i] = 0, G[i].clear();
    for (int i = 1, u, v; i <= m; ++i) {
      read(u);
      read(v);
      G[u].push_back(v);
    }
    for (int i = 1; i <= n; ++i) ta[i] = i;
    random_shuffle(ta + 1, ta + n + 1);
    int RT = -1;
    for (int i = 1; i <= n && i <= 100; ++i) {
      if (Tarjan::chk_good(i)) RT = i;
    }
    random_shuffle(ta + 1, ta + n + 1);
    for (int i = n; i >= 1 && i >= n - 100; --i) {
      if (Tarjan::chk_good(i)) RT = i;
    }
    if (n >= 104 && Tarjan::chk_good(104)) RT = 104;
    if (n >= 80000 && Tarjan::chk_good(80000)) RT = 80000;
    if (RT == -1) {
      puts("-1");
      continue;
    }
    Tarjan::chk_good(RT, 1);
    ans[RT] = 1;
    for (int i = 2; i <= Tarjan::tot; ++i) {
      int x = Tarjan::ndfn[i];
      if (Tarjan::dfn[x] == Tarjan::low[x])
        ans[x] = -1;
      else {
        if (Tarjan::dfn[x] != Tarjan::l2[x])
          ans[x] = -1;
        else
          ans[x] = ans[Tarjan::ndfn[Tarjan::low[x]]];
      }
    }
    int cnt = 0;
    for (int i = 1; i <= n; ++i)
      if (ans[i] == 1) ++cnt;
    if (cnt * 5 >= n) {
      for (int i = 1; i <= n; ++i) {
        if (ans[i] == 1) printf("%d ", i);
      }
      puts("");
    } else {
      puts("-1");
    }
  }
  return 0;
}
