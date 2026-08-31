#include <bits/stdc++.h>
using std::cin;
using std::cout;
using std::endl;
using std::string;
void __Check(bool condition, const char* expression, int line) {
  if (!condition) {
    fprintf(stderr, "Check failed at line %d: %s\n", line, expression);
    exit(-1);
  }
}
template <class Collection, class Key>
bool ContainsKey(const Collection& collection, const Key& key) {
  return collection.find(key) != collection.end();
}
const int INF = 0x3F3F3F3F;
const long long INF64 = 0x3F3F3F3F3F3F3F3F;
const int INIT = -1;
int n, m, k;
std::vector<std::pair<int, int> > g[4];
int pos[4];
void Solve() {
  if (((int)g[3].size()) + std::min(((int)g[1].size()), ((int)g[2].size())) <
      k) {
    cout << "-1" << endl;
    return;
  }
  int want3 = std::min(((int)g[3].size()), k);
  int cnt = want3;
  int sum = 0;
  for (; pos[3] < want3; pos[3]++) {
    sum += g[3][pos[3]].first;
  }
  for (int i = want3; i < k; i++) {
    sum += g[1][pos[1]++].first;
    sum += g[2][pos[2]++].first;
    cnt += 2;
  }
  (__Check(pos[1] == pos[2], "pos[1] == pos[2]", 60));
  (__Check(want3 + 2 * pos[1] >= k, "want3 + 2 * pos[1] >= k", 61));
  if (cnt > m) {
    cout << "-1" << endl;
    return;
  }
  for (; cnt < m; cnt++) {
    std::vector<int> ar = {
        pos[0] < ((int)g[0].size()) ? g[0][pos[0]].first : INF,
        pos[1] < ((int)g[1].size()) ? g[1][pos[1]].first : INF,
        pos[2] < ((int)g[2].size()) ? g[2][pos[2]].first : INF,
        pos[3] < ((int)g[3].size()) ? g[3][pos[3]].first : INF};
    if (pos[3] > 0 && pos[1] < ((int)g[1].size()) &&
        pos[2] < ((int)g[2].size())) {
      int last3 = g[3][pos[3] - 1].first;
      int next12 = g[1][pos[1]].first + g[2][pos[2]].first;
      int cost = next12 - last3;
      ar.push_back(cost);
    }
    int mi = std::min_element((ar).begin(), (ar).end()) - ar.begin();
    if (mi == 4) {
      sum -= g[3][--pos[3]].first;
      sum += g[1][pos[1]++].first;
      sum += g[2][pos[2]++].first;
    } else {
      sum += g[mi][pos[mi]++].first;
    }
  }
  cout << sum << endl;
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < pos[i]; j++) {
      cout << g[i][j].second + 1 << " ";
    }
  }
  cout << endl;
}
int main() {
  cin >> n >> m >> k;
  for (int i = 0; i < n; i++) {
    int t, x, y;
    cin >> t >> x >> y;
    int idx = (x << 1) | y;
    g[idx].push_back({t, i});
  }
  for (int i = 0; i < 4; i++) {
    std::sort((g[i]).begin(), (g[i]).end());
  }
  Solve();
}
