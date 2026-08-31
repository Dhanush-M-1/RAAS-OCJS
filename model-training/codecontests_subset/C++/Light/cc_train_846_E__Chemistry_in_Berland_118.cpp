#include <bits/stdc++.h>
using namespace std;
const int N = 100000;
long long A[N + 5], B[N + 5], K[N + 5];
int X[N + 5];
vector<int> G[N + 5];
bool vst[N + 5];
long long inf = 1e18;
bool dfs(int s, int p) {
  vst[s] = true;
  for (int u : G[s]) {
    if (vst[u]) continue;
    if (!dfs(u, s)) return false;
  }
  if (s == 1) return B[s] >= A[s];
  if (A[s] > B[s]) {
    if (X[s] == p) {
      long long diff = A[s] - B[s];
      if (1. * diff * K[s] >= inf) return false;
      B[p] -= diff * K[s];
    } else
      B[p] -= A[s] - B[s];
    if (B[p] <= -inf) return false;
    B[s] = A[s];
  } else {
    if (X[p] == s) {
      long long diff = B[s] - A[s];
      diff = diff / K[p] * K[p];
      B[p] += diff / K[p];
      B[s] -= diff;
    } else {
      B[p] += B[s] - A[s];
      B[s] = A[s];
    }
  }
  return true;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &B[i]);
  for (int i = 1; i <= n; i++) scanf("%lld", &A[i]);
  for (int i = 2; i <= n; i++) {
    scanf("%lld%lld", &X[i], &K[i]);
    G[i].push_back(X[i]);
    G[X[i]].push_back(i);
  }
  puts(dfs(1, -1) ? "YES" : "NO");
  return 0;
}
