#include <bits/stdc++.h>
using namespace std;
long long n, i, j, k, R;
vector<long long> L, C, A, P;
vector<vector<long long>> g;
void dfs(long long u = R, long long p = 0) {
  L[u] = L[p] + 1;
  for (long long v : g[u]) {
    if (v != p) {
      dfs(v, u);
    }
  }
}
void dft(long long u) {
  if (C[u] % 2 or C[u] < 0) return;
  A.push_back(u);
  C[u] = -1;
  for (long long v : g[u]) {
    C[v]--;
    if (L[u] < L[v]) dft(v);
  }
}
bool cmp(long long i, long long j) { return L[i] > L[j]; }
int main() {
  cin >> n;
  g.resize(n + 1);
  C.assign(n + 1, 0);
  L = C;
  P.resize(n);
  for (i = 1; i <= n; i++) {
    cin >> j;
    P[i - 1] = i;
    if (j) {
      C[i]++;
      C[j]++;
      g[i].push_back(j);
      g[j].push_back(i);
    } else
      R = i;
  }
  dfs();
  sort(P.begin(), P.end(), cmp);
  for (long long i : P) dft(i);
  if (A.size() != n)
    cout << "NO\n";
  else {
    cout << "YES\n";
    for (long long i : A) cout << i << "\n";
  }
}
