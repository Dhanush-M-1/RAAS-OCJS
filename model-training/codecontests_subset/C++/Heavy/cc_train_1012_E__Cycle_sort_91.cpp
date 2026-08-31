#include <bits/stdc++.h>
using namespace std;
using uint = unsigned int;
using ll = long long;
using pii = pair<int, int>;
int n, s;
int a[200010], b[200010];
int p[200010];
bool used[200010];
int fth[200010];
vector<vector<int>> cycles;
map<int, vector<int>> v, pos;
int root(int x) { return fth[x] == -1 ? x : fth[x] = root(fth[x]); }
bool join(int x, int y) {
  x = root(x);
  y = root(y);
  if (x == y) return false;
  if ((x + y) & 1)
    fth[x] = y;
  else
    fth[y] = x;
  return true;
}
void getMinPerm() {
  int i;
  for (i = 1; i <= n; ++i) b[i] = a[i];
  sort(b + 1, b + n + 1);
  for (i = 1; i <= n; ++i)
    if (a[i] != b[i]) v[b[i]].push_back(i);
  for (i = 1; i <= n; ++i) {
    if (a[i] == b[i])
      p[i] = i;
    else {
      p[i] = v[a[i]].back();
      v[a[i]].pop_back();
    }
  }
  for (i = 1; i <= n; ++i) join(i, p[i]);
  for (i = 1; i <= n; ++i)
    if (a[i] != b[i]) pos[a[i]].push_back(i);
  for (const auto &item : pos) {
    for (auto val : item.second)
      if (join(p[val], p[item.second[0]])) {
        swap(p[val], p[item.second[0]]);
      }
  }
}
void solve() {
  int i, t;
  for (t = 0, i = 1; i <= n; ++i) {
    if (p[i] == i) continue;
    if (used[i]) continue;
    cycles.push_back(vector<int>());
    for (int j = i; !used[j]; used[j] = true, j = p[j])
      cycles.back().push_back(j);
    t += cycles.back().size();
  }
  int m = cycles.size();
  int x = max(m + t - s, 0);
  int y = m - x;
  if (t > s) return void(cout << "-1\n");
  cout << (x + min(y, 2)) << '\n';
  if (y == 1) ++x;
  while (x--) {
    cout << cycles.back().size() << '\n';
    for (auto val : cycles.back()) cout << val << ' ';
    cout << '\n';
    cycles.pop_back();
  }
  if (cycles.empty()) return;
  int sum = 0;
  for (i = cycles.size() - 1; i >= 0; --i) sum += cycles[i].size();
  cout << '\n';
  cout << sum << '\n';
  for (const auto &vec : cycles) {
    for (auto val : vec) cout << val << ' ';
  }
  cout << '\n';
  cout << cycles.size() << '\n';
  for (i = cycles.size() - 1; i >= 0; --i) cout << cycles[i][0] << ' ';
  cout << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  int i;
  memset(fth, -1, sizeof fth);
  cin >> n >> s;
  for (i = 1; i <= n; ++i) cin >> a[i];
  getMinPerm();
  solve();
  return 0;
}
