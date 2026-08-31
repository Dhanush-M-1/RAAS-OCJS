#include <bits/stdc++.h>
using namespace std;
const int inf = ~0U >> 1;
const long long INF = ~0LLU >> 1;
int rd() { return RAND_MAX == 32767 ? ((rand() << 15) ^ rand()) : rand(); }
template <class T>
void Read_T(T &x) {
  char ch;
  while ((ch = getchar()) && (ch < '0' || ch > '9'))
    ;
  x = ch - '0';
  while ((ch = getchar()) && ch >= '0' && ch <= '9') x = x * 10 + ch - '0';
}
template <class T>
void Read_S(T &x) {
  char opt, ch = 1;
  while ((opt = ch) && (ch = getchar()) && (ch < '0' || ch > '9'))
    ;
  x = ch - '0';
  while ((ch = getchar()) && ch >= '0' && ch <= '9') x = x * 10 + ch - '0';
  if (opt == '-') x = -x;
}
const int maxn = 3010;
int n, m, cnt, pos, tal;
int p[maxn], col[maxn], cir[maxn], ins[maxn];
double res;
vector<int> G[maxn];
void Dfs(int t, int fa) {
  p[t] = fa;
  ins[t] = 1;
  for (__typeof(G[t].begin()) e = G[t].begin(); e != G[t].end(); e++)
    if (*e == fa)
      continue;
    else if (!ins[*e])
      Dfs(*e, t);
    else if (pos == -1) {
      pos = t;
      tal = *e;
    }
}
void Color(int t, int p, int c) {
  col[t] = c;
  for (__typeof(G[t].begin()) e = G[t].begin(); e != G[t].end(); e++)
    if (*e != p && ins[*e] == -1) Color(*e, t, c);
}
void Search(int t, int p, int dep) {
  if (col[t] == col[cnt])
    res += 1.0 / dep;
  else {
    int ret0 = abs(ins[col[t]] - ins[col[cnt]]) - 1;
    int ret1 = m - 2 - ret0;
    int d = dep - ret0;
    res += 1.0 / (d + ret0) + 1.0 / (d + ret1) - 1.0 / (d + ret0 + ret1);
  }
  for (__typeof(G[t].begin()) e = G[t].begin(); e != G[t].end(); e++)
    if (*e != p) Search(*e, t, dep + 1);
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int u, v;
    cin >> u >> v;
    G[u].push_back(v);
    G[v].push_back(u);
  }
  memset(ins, 0, sizeof(ins));
  pos = -1;
  Dfs(0, -1);
  m = 0;
  memset(ins, -1, sizeof(ins));
  for (int i = pos; i != tal; i = p[i]) {
    cir[m] = i;
    ins[i] = m++;
  }
  cir[m] = tal;
  ins[tal] = m++;
  for (int i = 0; i < m; i++) Color(cir[i], -1, cir[i]);
  for (__typeof(G[cir[0]].begin()) e = G[cir[0]].begin(); e != G[cir[0]].end();
       e++)
    if (*e == cir[m - 1]) {
      G[cir[0]].erase(e);
      break;
    }
  for (__typeof(G[cir[m - 1]].begin()) e = G[cir[m - 1]].begin();
       e != G[cir[m - 1]].end(); e++)
    if (*e == cir[0]) {
      G[cir[m - 1]].erase(e);
      break;
    }
  res = 0;
  for (cnt = 0; cnt < n; cnt++) Search(cnt, -1, 1);
  cout << fixed << setprecision(9) << res << endl;
  return 0;
}
