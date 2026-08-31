#include <bits/stdc++.h>
using namespace std;
void ga(int N, int *A) {
  for (int i(0); i < N; i++) scanf("%d", A + i);
}
vector<pair<int, int> > g[100005];
long long A[100005], B[100005];
int N, a, b;
long long dfs(int u) {
  long long S = A[u] - B[u], a;
  for (auto &h : g[u]) {
    a = dfs(h.first);
    if (a >= 0)
      S += a;
    else if (-a * 1. * h.second > 2e17)
      puts("NO"), exit(0);
    else
      S += a * h.second;
    if (S > 2e17) puts("NO"), exit(0);
  }
  return S;
}
int main(void) {
  scanf("%d", &N);
  for (int i(0); i < N; i++) scanf("%lld", A + i);
  for (int i(0); i < N; i++) scanf("%lld", B + i);
  for (int k(1); k < N; k++) scanf("%d%d", &a, &b), g[--a].push_back({k, b});
  puts(dfs(0) >= 0 ? "YES" : "NO");
  return 0;
}
