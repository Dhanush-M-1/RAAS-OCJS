#include <bits/stdc++.h>
using namespace std;
const int N = 80;
struct minion {
  int a, b, ind;
  bool operator<(const minion &other) const { return b < other.b; }
} minions[N];
int n, k;
int memo[N][N], vis[N][N], vid;
int solve(int i, int cnt) {
  if (i == n) return cnt == k ? 0 : -1e9;
  int &ret = memo[i][cnt];
  if (vis[i][cnt] == vid) return ret;
  vis[i][cnt] = vid;
  ret = solve(i + 1, cnt) + minions[i].b * (k - 1);
  if (cnt < k)
    ret = max(ret, solve(i + 1, cnt + 1) + minions[i].a + minions[i].b * cnt);
  return ret;
}
vector<int> keep, dest;
void path(int i, int cnt) {
  if (i == n) return;
  if (solve(i + 1, cnt) + minions[i].b * (k - 1) == solve(i, cnt)) {
    dest.push_back(minions[i].ind);
    return path(i + 1, cnt);
  }
  keep.push_back(minions[i].ind);
  path(i + 1, cnt + 1);
}
void run() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> minions[i].a >> minions[i].b;
    minions[i].ind = i + 1;
  }
  sort(minions, minions + n);
  ++vid;
  keep.clear();
  dest.clear();
  path(0, 0);
  cout << keep.size() + dest.size() * 2 << '\n';
  for (int i = 0; i + 1 < keep.size(); i++) cout << keep[i] << ' ';
  for (int x : dest) cout << x << ' ' << -x << ' ';
  cout << keep.back() << '\n';
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int t;
  cin >> t;
  while (t--) run();
}
