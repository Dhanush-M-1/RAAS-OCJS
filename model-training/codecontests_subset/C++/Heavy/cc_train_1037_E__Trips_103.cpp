#include <bits/stdc++.h>
#pragma warning(disable : 4996)
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("-ffloat-store")
using namespace std;
const int MN = 200010;
set<int> e[MN];
int from[MN], to[MN], deg[MN], vis[MN], res[MN];
int n, m, k, cnt;
void deletev(int v) {
  if (deg[v] >= k || vis[v]) return;
  queue<int> q;
  q.push(v);
  vis[v] = 1;
  --cnt;
  while (!q.empty()) {
    int top = q.front();
    q.pop();
    for (auto& c : e[top]) {
      --deg[c];
      if (deg[c] < k && !vis[c]) {
        q.push(c);
        vis[c] = 1;
        --cnt;
      }
    }
  }
}
struct E {
  void solve(std::istream& cin, std::ostream& cout) {
    cin >> n >> m >> k;
    memset(deg, (0), sizeof(deg));
    memset(from, (0), sizeof(from));
    memset(to, (0), sizeof(to));
    memset(deg, (0), sizeof(deg));
    memset(vis, (0), sizeof(vis));
    memset(res, (0), sizeof(res));
    e->clear();
    for (int i = (0); i < (m); ++i) {
      cin >> from[i] >> to[i];
      --from[i], --to[i];
      ++deg[from[i]], ++deg[to[i]];
      e[from[i]].insert(to[i]);
      e[to[i]].insert(from[i]);
    }
    cnt = n;
    for (int i = (0); i < (n); ++i) {
      deletev(i);
    }
    res[m] = cnt;
    for (int i = (m - 1); i >= (0); --i) {
      if (!vis[from[i]]) --deg[to[i]];
      if (!vis[to[i]]) --deg[from[i]];
      e[from[i]].erase(to[i]);
      e[to[i]].erase(from[i]);
      deletev(from[i]);
      deletev(to[i]);
      res[i] = cnt;
    }
    for (int i = (1); i <= (m); ++i) cout << res[i] << "\n";
  }
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  E solver;
  std::istream& in(std::cin);
  std::ostream& out(std::cout);
  solver.solve(in, out);
  return 0;
}
