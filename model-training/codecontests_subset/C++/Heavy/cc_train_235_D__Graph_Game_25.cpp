#include <bits/stdc++.h>
using namespace std;
inline long long rd() {
  long long _x = 0;
  int _ch = getchar(), _f = 1;
  for (; !isdigit(_ch) && (_ch != '-') && (_ch != EOF); _ch = getchar())
    ;
  if (_ch == '-') {
    _f = 0;
    _ch = getchar();
  }
  for (; isdigit(_ch); _ch = getchar()) _x = _x * 10 + _ch - '0';
  return _f ? _x : -_x;
}
void write(long long _x) {
  if (_x >= 10)
    write(_x / 10), putchar(_x % 10 + '0');
  else
    putchar(_x + '0');
}
inline void wrt(long long _x, char _p) {
  if (_x < 0) putchar('-'), _x = -_x;
  write(_x);
  if (_p) putchar(_p);
}
int nx[3005 << 1], to[3005 << 1], hd[3005], cnt;
inline void add(int u, int v) { nx[++cnt] = hd[u], to[cnt] = v, hd[u] = cnt; }
int sta[3005], top;
int in[3005], len, n;
bool vis[3005], flag;
void dfs(int u, int fa) {
  sta[++top] = u, vis[u] = 1;
  for (int i = hd[u]; i; i = nx[i])
    if (to[i] != fa) {
      if (!vis[to[i]])
        dfs(to[i], u);
      else {
        flag = 1;
        while (sta[top + 1] != to[i]) {
          in[sta[top]] = 1, top--, len++;
        }
        return;
      }
      if (flag) return;
    }
  top--;
}
double Ans;
void solve(int x, int y) {
  if (y <= 1)
    Ans += 1 / double(x);
  else {
    int Sum = x - y + len;
    Ans -= 1 / double(Sum);
    Ans += 1 / double(Sum - (y - 2));
    Ans += 1 / double(Sum - (len - y));
  }
}
void DFS(int u, int len1, int len2) {
  vis[u] = 1, solve(len1, len2);
  for (int i = hd[u]; i; i = nx[i])
    if (!vis[to[i]]) DFS(to[i], len1 + 1, len2 + in[to[i]]);
}
int main() {
  n = rd();
  for (int i = int(1); i <= (int)(n); i++) {
    int x = rd() + 1, y = rd() + 1;
    add(x, y), add(y, x);
  }
  dfs(1, 0);
  for (int i = int(1); i <= (int)(n); i++) {
    memset(vis, 0, sizeof vis);
    DFS(i, 1, in[i]);
  }
  printf("%.10lf\n", Ans);
}
