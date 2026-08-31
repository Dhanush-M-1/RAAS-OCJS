#include <bits/stdc++.h>
using namespace std;
int N, M, Q;
pair<pair<int, int>, pair<int, int> > E[1000005];
int par[2005];
int find_parent(int x) {
  if (par[x] == x) return x;
  return par[x] = find_parent(par[x]);
}
int go(int li, int ri) {
  for (int i = 1; i <= 2 * N + 1; i++) par[i] = i;
  for (int i = M - 1; i >= 0; i--)
    if (li <= E[i].first.second && E[i].first.second <= ri) {
      int a = E[i].second.first, b = E[i].second.second;
      if (find_parent(2 * a) == find_parent(2 * b)) return E[i].first.first;
      par[find_parent(2 * a)] = find_parent(2 * b + 1);
      par[find_parent(2 * a + 1)] = find_parent(2 * b);
    }
  return -1;
}
int main() {
  scanf("%d %d %d", &N, &M, &Q);
  for (int i = 0; i < M; i++) {
    scanf("%d %d %d", &E[i].second.first, &E[i].second.second,
          &E[i].first.first);
    E[i].first.second = i + 1;
  }
  sort(E, E + M);
  for (int i = 0, li, ri; i < Q; i++) {
    scanf("%d %d", &li, &ri);
    printf("%d\n", go(li, ri));
  }
  return 0;
}
