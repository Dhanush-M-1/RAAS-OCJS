#include <bits/stdc++.h>
using namespace std;
inline int read() {
  char ch = getchar();
  int w = 1, c = 0;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') w = -1;
  for (; isdigit(ch); ch = getchar()) c = (c << 1) + (c << 3) + (ch ^ 48);
  return w * c;
}
const int M = 2e5 + 10;
vector<int> v[M];
int n, m, dep[M], t[M], s[M], stk[M];
bool bad[M], flag, in[M];
void clr() {
  for (int i = (1); i <= (n); ++i) v[i].clear(), bad[i] = 0;
}
void dfs(int x, int fa) {
  in[x] = 1;
  dep[x] = dep[fa] + 1;
  bool fl = 0;
  for (int y : v[x]) {
    if (dep[y]) {
      if (!in[y]) {
        flag = 1;
      } else {
        if (dep[y] < dep[x]) {
          t[x] = min(t[x], dep[y]);
          s[x]++;
          s[y]--;
        }
      }
    } else
      dfs(y, x);
  }
  in[x] = 0;
}
void ga(int x, int fa) {
  for (int y : v[x]) {
    if (dep[y] > dep[x]) {
      ga(y, x);
      t[x] = min(t[y], t[x]);
      s[x] += s[y];
    }
  }
}
int num;
void dfs1(int x, int fa) {
  stk[dep[x]] = x;
  if (s[x] >= 2)
    bad[x] = 1;
  else if (t[x] < 1e9)
    bad[x] = bad[stk[t[x]]];
  num += !bad[x];
  for (int y : v[x]) {
    if (dep[y] > dep[x]) {
      dfs1(y, x);
    }
  }
}
void doit(int x) {
  num = 0;
  ga(x, 0);
  dfs1(x, 0);
  int lim = n / 5;
  if (n % 5 == 0) lim--;
  if (num <= lim) {
    puts("-1");
    return;
  }
  for (int i = (1); i <= (n); ++i) {
    if (!bad[i]) cout << i << " ";
  }
  cout << "\n";
}
void work() {
  clr();
  n = read();
  m = read();
  for (int i = (1); i <= (m); ++i) {
    int x = read(), y = read();
    v[x].push_back(y);
  }
  for (int T = (1); T <= (188); ++T) {
    int x = 1ll * rand() * rand() % n + 1;
    flag = 0;
    for (int i = (1); i <= (n); ++i) dep[i] = s[i] = 0, t[i] = 1e9;
    dfs(x, 0);
    if (!flag) {
      doit(x);
      return;
    }
  }
  puts("-1");
}
int main() {
  int T = read();
  srand(19260817);
  while (T--) work();
  return 0;
}
