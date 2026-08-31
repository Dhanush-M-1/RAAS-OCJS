#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10, NX = 1e9 + 7;
int n, m, r, t, a, b, A[N], D[N], M[N];
set<int> V[N];
set<pair<int, int> > S;
void DFS(int v, int p) {
  int c = 0;
  for (auto X : V[v]) {
    if (X == p) continue;
    DFS(X, v);
    c += !M[X];
  }
  if (c & 1) M[v] = 1, c++;
  D[v] -= c;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &r);
    if (r) V[i].insert(r), V[r].insert(i);
  }
  if (n % 2 == 0) return !printf("NO");
  for (int i = 1; i <= n; i++) D[i] = V[i].size();
  printf("YES\n");
  DFS(1, 0);
  for (int i = 1; i <= n; i++) S.insert({D[i], i});
  while (S.size()) {
    auto X = *S.begin();
    S.erase(S.begin());
    for (auto v : V[X.second]) {
      V[v].erase(X.second);
      S.erase({D[v], v});
      D[v]--;
      S.insert({D[v], v});
    }
    V[X.second].clear();
    printf("%d\n", X.second);
  }
  return (0);
}
