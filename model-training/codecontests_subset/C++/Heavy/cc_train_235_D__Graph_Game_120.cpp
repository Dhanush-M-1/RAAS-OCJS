#include <bits/stdc++.h>
using namespace std;
int g() {
  char ch;
  bool f = 0;
  while (!((ch = getchar() - 48) >= 0))
    if (ch == -3) f = 1;
  int v = ch;
  while (((ch = getchar() - 48) >= 0)) v = v * 10 + ch;
  return f ? -v : v;
}
const int Maxn = 3005;
vector<int> p[Maxn];
long double ans;
int n, R;
bool mark[Maxn], belong[Maxn];
int FC(int x, int fa) {
  mark[x] = true;
  for (int i = 0; i < p[x].size(); i++)
    if (!mark[p[x][i]]) {
      int te = FC(p[x][i], x);
      if (te) {
        if (te > 0) belong[x] = true, R++;
        return te == x ? -1 : te;
      }
    } else if (p[x][i] != fa) {
      belong[x] = true;
      R = 1;
      return p[x][i];
    }
}
int pre, tot;
void dfs(int x) {
  mark[x] = true;
  pre += belong[x] == true;
  tot++;
  if (pre > 1) {
    int C = tot + R - pre, B = pre - 2, A = R - pre;
    ans += 1.0 / (C - B) + 1.0 / (C - A) - 1.0 / C;
  } else
    ans += 1.0 / tot;
  for (int i = 0; i < p[x].size(); i++)
    if (!mark[p[x][i]]) dfs(p[x][i]);
  pre -= belong[x] == true;
  tot--;
}
int x, y;
int main() {
  n = g();
  for (int i = 1; i <= n; i++) {
    x = g() + 1;
    y = g() + 1;
    p[x].push_back(y);
    p[y].push_back(x);
  }
  FC(1, 0);
  for (int i = 1; i <= n; i++) memset(mark, 0, sizeof(mark)), dfs(i);
  printf("%.9lf\n", (double)ans);
  return 0;
}
