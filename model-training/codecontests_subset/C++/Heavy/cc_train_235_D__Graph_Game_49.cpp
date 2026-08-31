#include <bits/stdc++.h>
using namespace std;
void Get_Val(int &Ret) {
  Ret = 0;
  char ch;
  while (ch = getchar(), ch > '9' || ch < '0')
    ;
  do {
    (Ret *= 10) += ch - '0';
  } while (ch = getchar(), ch >= '0' && ch <= '9');
}
const int Max_N(3050);
namespace UFS {
int Father[Max_N];
int Get_Father(const int &x) {
  return Father[x] == x ? x : Father[x] = Get_Father(Father[x]);
}
}  // namespace UFS
int N, Head[Max_N], Total, To[Max_N << 1], Next[Max_N << 1], Deep[Max_N];
int Tot, circle[Max_N], root[Max_N];
inline void Add_Edge(const int &s, const int &t) {
  ++Total, To[Total] = t, Next[Total] = Head[s], Head[s] = Total;
}
void init() {
  Get_Val(N);
  for (int i = 1; i <= N; ++i) UFS::Father[i] = i;
  for (int i = 1, a, b; i <= N; ++i) {
    Get_Val(a), Get_Val(b), ++a, ++b;
    if (UFS::Get_Father(a) != UFS::Get_Father(b)) {
      Add_Edge(a, b), Add_Edge(b, a);
      UFS::Father[UFS::Get_Father(a)] = UFS::Get_Father(b);
    } else
      circle[0] = a, circle[N + 1] = b;
  }
}
void dfs(const int &u) {
  for (int i = Head[u], v; i; i = Next[i])
    if (!root[v = To[i]]) root[v] = root[u], Deep[v] = Deep[u] + 1, dfs(v);
}
int Pre[Max_N];
void prepare() {
  queue<int> Q;
  Q.push(circle[0]), Pre[circle[0]] = -1;
  int u, v;
  while (Q.size()) {
    u = Q.front(), Q.pop();
    for (int i = Head[u], v; i; i = Next[i])
      if (!Pre[v = To[i]]) Pre[v] = u, Q.push(v);
  }
  u = circle[N + 1];
  while (u != -1) circle[root[u] = ++Tot] = u, u = Pre[u];
  for (int i = 1; i <= Tot; ++i) Deep[u = circle[i]] = 1, dfs(u);
}
double Ans;
void dfs(const int &u, const int &dis) {
  Pre[u] = 1;
  Ans += 1.0 / (dis * 1.0);
  for (int i = Head[u], v; i; i = Next[i])
    if (!Pre[v = To[i]] && root[u] == root[v]) dfs(v, dis + 1);
}
inline int Abs(const int &x) { return x >= 0 ? x : -x; }
void work() {
  for (int u = 1; u <= N; ++u) {
    memset(Pre, 0, sizeof(Pre)), dfs(u, 1);
    for (int v = 1, a, b; v <= N; ++v)
      if (root[u] != root[v]) {
        a = Abs(root[u] - root[v]), b = Tot - Abs(root[u] - root[v]);
        Ans += 1.0 / (Deep[u] + Deep[v] + a - 1);
        Ans += 1.0 / (Deep[u] + Deep[v] + b - 1);
        Ans -= 1.0 / (Deep[u] + Deep[v] + Tot - 2);
      }
  }
  printf("%.10lf", Ans);
}
int main() {
  init();
  prepare();
  work();
  return 0;
}
