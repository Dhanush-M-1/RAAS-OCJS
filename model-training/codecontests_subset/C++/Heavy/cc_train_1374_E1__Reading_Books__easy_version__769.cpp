#include <bits/stdc++.h>
using namespace std;
const int inf = 1 << 30;
const long long mod = 1e9 + 7;
const long long linf = 1LL << 62;
const double EPS = 1e-7;
template <class T>
void chmin(T& x, T y) {
  if (x > y) x = y;
}
template <class T>
void chmax(T& x, T y) {
  if (x < y) x = y;
}
int n, m, k;
vector<pair<long long, long long> > g[4];
int solve(int mode, int pos) {
  if (pos == -1) {
    cout << -1 << endl;
    return 0;
  }
  int mx = min((int)g[0].size(), m);
  int ones = max(k - mx, 0);
  if (ones > min(g[1].size(), g[2].size()) || mx + ones * 2 > m) {
    return -1;
  }
  long long sum = 0;
  for (int i = 0; i < mx; i++) sum += g[0][i].first;
  set<pair<int, int> > fr, mn;
  for (int i = 0; i < ones; i++) sum += g[1][i].first + g[2][i].first;
  for (int i = ones; i < g[1].size(); i++) fr.insert(g[1][i]);
  for (int i = ones; i < g[2].size(); i++) fr.insert(g[2][i]);
  for (auto u : g[3]) fr.insert(u);
  for (int i = 0; i < m - (ones * 2 + mx); i++) {
    sum += fr.begin()->first;
    mn.insert(*fr.begin());
    fr.erase(fr.begin());
  }
  long long res = mx, val = sum;
  for (int sz11 = mx - 1; sz11 >= 0; sz11--) {
    if (mode == 1 && pos > sz11) break;
    if (fr.empty()) break;
    sum -= g[0][sz11].first;
    sum += fr.begin()->first;
    mn.insert(*fr.begin());
    fr.erase(fr.begin());
    if (sz11 < k) {
      if (ones < g[1].size() && ones < g[2].size()) {
        if (mn.size() < 2) break;
        auto f = [&](int num) {
          if (mn.find(g[num][ones]) != mn.end()) {
            mn.erase(g[num][ones]);
          } else {
            sum += g[num][ones].first;
            auto it = mn.end();
            it--;
            sum -= it->first;
            mn.erase(it);
          }
        };
        f(1), f(2);
        ones++;
      } else {
        break;
      }
    }
    if (val > sum) {
      res = sz11;
      val = sum;
    }
  }
  if (mode == 1) {
    cout << val << endl;
    for (int i = 0; i < pos; i++) cout << g[0][i].second << " ";
    for (int i = 0; i < ones; i++) cout << g[1][i].second << " ";
    for (int i = 0; i < ones; i++) cout << g[2][i].second << " ";
    for (auto u : mn) cout << u.second << " ";
    cout << endl;
  }
  return res;
}
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      g[0].push_back({t, i});
    else if (a == 1)
      g[1].push_back({t, i});
    else if (b == 1)
      g[2].push_back({t, i});
    else
      g[3].push_back({t, i});
  }
  for (int i = 0; i < 4; i++) sort(g[i].begin(), g[i].end());
  solve(1, solve(0, 0));
}
