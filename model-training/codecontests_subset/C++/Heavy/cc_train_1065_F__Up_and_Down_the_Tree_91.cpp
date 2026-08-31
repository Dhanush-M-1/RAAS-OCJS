#include <bits/stdc++.h>
using namespace std;
const int N = 1000003;
const int M = N << 1;
const int INF = 2e9;
int n, K;
int cnt, head[N], Next[M], v[M];
int b[N];
long long w[N];
int pre[N], dfn[N], clo, kth[N], s[N];
int mn[N], dep[N];
int top[N];
void read(int &x) {
  char ch = getchar();
  x = 0;
  int w = 0;
  for (; ch < '0' || ch > '9'; ch = getchar()) w |= (ch == '-');
  for (; ch >= '0' && ch <= '9'; ch = getchar())
    x = (x << 3) + (x << 1) + ch - '0';
  if (w) x = -x;
}
void add(int x, int y) {
  Next[++cnt] = head[x];
  head[x] = cnt;
  v[cnt] = y;
}
int predfs(int x, int fa, int d) {
  s[d] = x;
  dep[x] = d;
  if (d - K > 0)
    kth[x] = s[d - K];
  else
    kth[x] = 1;
  if (!head[x]) mn[x] = x;
  for (int i = head[x]; i; i = Next[i]) {
    int val = predfs(v[i], x, d + 1);
    if (dep[val] < dep[mn[x]]) mn[x] = val;
  }
  return mn[x];
}
void dfs(int x, int fa) {
  long long mx = 0;
  for (int i = head[x]; i; i = Next[i])
    if (v[i] != fa) {
      dfs(v[i], x);
      mx = max(mx, w[v[i]]);
    }
  w[x] += mx;
}
int getop(int x) {
  if (top[x]) return top[x];
  int y = mn[kth[x]];
  if (dep[y] == dep[x])
    return top[x] = kth[x];
  else
    return top[x] = getop(y);
}
int main() {
  read(n);
  read(K);
  int x;
  for (int i = (2); i <= (n); i++) {
    read(x);
    add(x, i);
  }
  dep[0] = INF;
  predfs(1, 0, 0);
  for (int i = (1); i <= (n); i++)
    if (!head[i]) getop(i);
  for (int i = (1); i <= (n); i++)
    if (!head[i]) w[top[i]]++;
  dfs(1, 0);
  long long mx = 0;
  for (int i = (1); i <= (n); i++) mx = max(mx, w[i]);
  cout << w[1] << endl;
  return 0;
}
