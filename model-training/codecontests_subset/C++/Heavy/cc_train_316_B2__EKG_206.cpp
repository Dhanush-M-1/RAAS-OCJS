#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 5;
int n, m, a[N], cur, b[N];
bool used[N];
void dfs(int v) {
  cur++;
  if (a[v]) {
    dfs(a[v]);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i]) {
      b[a[i]] = i;
    }
  }
  bitset<N> dp;
  dfs(m);
  dp[cur] = true;
  int z = m;
  while (z > 0) {
    int x = b[z];
    b[z] = N;
    z = x;
  }
  for (int i = 1; i <= n; i++) {
    if (!b[i]) {
      cur = 0;
      dfs(i);
      dp |= (dp << cur);
    }
  }
  for (int i = 1; i < N; i++) {
    if (dp[i]) {
      cout << i << "\n";
    }
  }
}
