#include <bits/stdc++.h>
using namespace std;
void JIZZ(string output = "") {
  cout << output;
  exit(0);
}
const long double PI = 3.14159265358979323846264338327950288;
const long double eps = 1e-13;
const long long mod = 1e9 + 7;
vector<int> G[200005];
int p[200005], dep[200005], deg[200005];
bitset<200005> inq, del;
vector<int> ans;
void go(int now, int pa) {
  if (del[now]) return;
  ans.push_back(now);
  del[now] = 1;
  for (int i : G[now]) {
    if (i != pa) go(i, now);
  }
}
void dfs(int now, int pa) {
  ;
  ;
  for (int i : G[now]) {
    if (i == pa) continue;
    dfs(i, now);
  }
  if (deg[now] % 2 == 0) {
    go(now, pa);
    --deg[pa];
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  if (n == 1) exit((cout << "YES\n1\n", 0));
  if (n == 2) exit((cout << "NO" << endl, 0));
  int root = 0;
  for (int i = 1; i <= n; ++i) {
    int pa;
    cin >> pa;
    if (pa)
      G[pa].push_back(i), G[i].push_back(pa);
    else
      root = i;
  }
  for (int i = 1; i <= n; ++i) deg[i] = G[i].size();
  dfs(root, root);
  ;
  ;
  if (ans.size() != n) exit((cout << "NO" << endl, 0));
  cout << "YES" << endl;
  for (int i : ans) cout << i << '\n';
}
