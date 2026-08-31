#include <bits/stdc++.h>
using namespace std;
vector<int> g[100005], s[100005], A, B, C;
int i, j, k, t, l, m, n, w, f[100005], V[10005];
int go(int v) {
  vector<int> V;
  for (int i = 0; i < g[v].size(); i++)
    if (!f[s[v][i]]) {
      f[s[v][i]] = 1;
      w = go(g[v][i]);
      if (w) {
        A.push_back(v);
        B.push_back(g[v][i]);
        C.push_back(w);
      } else
        V.push_back(g[v][i]);
    }
  for (int i = 1; i < V.size(); i += 2)
    A.push_back(V[i]), B.push_back(v), C.push_back(V[i - 1]);
  if (V.size() % 2) return V.back();
  return 0;
}
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    g[x].push_back(y);
    g[y].push_back(x);
    s[x].push_back(i);
    s[y].push_back(i);
  }
  for (i = 1; i <= n; i++)
    if (go(i)) {
      cout << "No solution" << endl;
      return 0;
    }
  for (i = 0; i < A.size(); i++) printf("%d %d %d\n", A[i], B[i], C[i]);
}
