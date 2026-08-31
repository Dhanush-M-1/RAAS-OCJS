#include <bits/stdc++.h>
using namespace std;
vector<int> E[3005];
int deg[3005], V[3005];
int sz;
double ans;
void dfs(int r, int i, int A, int B) {
  deg[i] == 2 ? ++B : ++A;
  V[i] = r;
  if (B == sz)
    ans += 1.0 / (A + 2);
  else if (B <= 2)
    ans += 1.0 / (A + B);
  else
    ans += 1.0 / (A + B) + 1.0 / (A + sz - B + 2) - 1.0 / (A + sz);
  for (auto x : E[i])
    if (V[x] != r) dfs(r, x, A, B);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0, a, b; i < n; ++i)
    cin >> a >> b, E[a].push_back(b), E[b].push_back(a), ++deg[a], ++deg[b];
  queue<int> Q;
  for (int i = 0; i < n; ++i)
    if (deg[i] == 1) Q.push(i);
  while (!Q.empty()) {
    auto x = Q.front();
    Q.pop();
    for (auto y : E[x]) {
      --deg[y];
      if (deg[y] == 1) Q.push(y);
    }
  }
  for (int i = 0; i < n; ++i)
    if (deg[i] == 2) ++sz;
  fill(V, V + n, -1);
  for (int i = 0; i < n; ++i) dfs(i, i, 0, 0);
  cout << fixed;
  cout.precision(10);
  cout << ans << endl;
  return 0;
}
