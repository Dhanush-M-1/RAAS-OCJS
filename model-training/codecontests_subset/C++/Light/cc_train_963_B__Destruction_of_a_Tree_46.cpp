#include <bits/stdc++.h>
using namespace std;
int N;
set<int> E[202020];
set<int> cand;
int C[202020];
vector<int> V;
int dfs(int cur, int pre) {
  C[cur] = 1;
  for (auto& e : E[cur])
    if (e != pre) C[cur] += dfs(e, cur);
  return C[cur];
}
void dfs2(int cur, int pre) {
  if (C[cur] % 2 == 1) {
    for (auto& e : E[cur])
      if (e != pre) {
        if (C[e] % 2 == 0) dfs2(e, cur);
      }
    V.push_back(cur);
    for (auto& e : E[cur])
      if (e != pre) {
        if (C[e] % 2 == 1) dfs2(e, cur);
      }
  } else {
    for (auto& e : E[cur])
      if (e != pre) {
        if (C[e] % 2 == 0) dfs2(e, cur);
      }
    V.push_back(cur);
    for (auto& e : E[cur])
      if (e != pre) {
        if (C[e] % 2 == 1) dfs2(e, cur);
      }
  }
}
void solve() {
  int i, j, k, l, r, x, y;
  string s;
  cin >> N;
  if (N % 2 == 0) return (void)printf("NO\n");
  for (i = 1; i <= N; i++) {
    cin >> x;
    if (x) {
      E[i].insert(x);
      E[x].insert(i);
    }
  }
  dfs(1, 1);
  dfs2(1, 1);
  cout << "YES" << endl;
  for (auto& v : V) cout << v << endl;
}
int main(int argc, char** argv) {
  string s;
  int i;
  if (argc == 1) ios::sync_with_stdio(false), cin.tie(0);
  for (i = 0; i < (argc - 1); i++) s += argv[i + 1], s += '\n';
  for (i = 0; i < (s.size()); i++) ungetc(s[s.size() - 1 - i], stdin);
  cout.tie(0);
  solve();
  return 0;
}
