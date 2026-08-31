#include <bits/stdc++.h>
int n, m, k, ans;
std::set<int> g[200005];
std::vector<std::pair<int, int> > qr;
bool deleted[200005];
void check(int v) {
  if (deleted[v] || g[v].size() >= k) return;
  deleted[v] = true;
  ans--;
  for (auto &i : g[v]) g[i].erase(v);
  for (auto &i : g[v]) check(i);
}
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(0);
  std::cin >> n >> m >> k;
  ans = n;
  for (int i = 0; i < (m); ++i) {
    int a, b;
    std::cin >> a >> b;
    a--;
    b--;
    qr.push_back({a, b});
    g[a].insert(b);
    g[b].insert(a);
  }
  for (int i = 0; i < (n); ++i) check(i);
  std::reverse(qr.begin(), qr.end());
  std::vector<int> ret;
  ret.push_back(ans);
  for (int i = 0; i < (m - 1); ++i) {
    g[qr[i].first].erase(qr[i].second);
    g[qr[i].second].erase(qr[i].first);
    check(qr[i].first);
    check(qr[i].second);
    ret.push_back(ans);
  }
  for (int i = 0; i < (m); ++i) std::cout << ret[m - i - 1] << "\n";
  return 0;
}
