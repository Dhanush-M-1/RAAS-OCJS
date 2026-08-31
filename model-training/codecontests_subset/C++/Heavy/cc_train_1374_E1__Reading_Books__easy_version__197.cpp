#include <bits/stdc++.h>
using namespace std;
int n, m, k;
struct Node {
  int id, t, a, b;
  bool friend operator<(Node a, Node b) { return a.t < b.t; }
};
vector<Node> v[5];
int sz[5];
int pos[5], anspos[5];
int ans;
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    v[a * 2 + b].push_back(Node{i, t, a, b});
  }
  for (int i = 0; i <= 3; i++) sort(v[i].begin(), v[i].end());
  for (int i = 0; i <= 3; i++) sz[i] = v[i].size();
  ans = -1;
  int tmp = 0;
  for (auto x : v[3]) tmp += x.t;
  pos[3] = sz[3];
  for (int i = sz[3]; i >= 0; i--) {
    while (pos[1] + pos[3] < k && pos[1] < sz[1]) {
      tmp += v[1][pos[1]].t;
      pos[1]++;
    }
    while (pos[2] + pos[3] < k && pos[2] < sz[2]) {
      tmp += v[2][pos[2]].t;
      pos[2]++;
    }
    int last = m - pos[1] - pos[2] - pos[3] - pos[0];
    while (last < 0 && pos[0] > 0) {
      pos[0]--;
      tmp -= v[0][pos[0]].t;
      last++;
    }
    while (last > 0) {
      int fuck = -1;
      for (int i = 0; i < 4; i++)
        if (pos[i] < sz[i]) {
          if (fuck == -1 || v[i][pos[i]].t < v[fuck][pos[fuck]].t) fuck = i;
        }
      if (fuck == -1) break;
      tmp += v[fuck][pos[fuck]].t;
      pos[fuck]++;
      last--;
    }
    if (last == 0 && pos[1] + pos[3] >= k && pos[2] + pos[3] >= k) {
      if (ans == -1 || tmp < ans) {
        ans = tmp;
        memcpy(anspos, pos, sizeof(pos));
      }
    }
    pos[3]--;
    if (pos[3] >= 0) tmp -= v[3][pos[3]].t;
  }
  printf("%d\n", ans);
  if (ans == -1) return 0;
  vector<int> res;
  for (int i = 0; i < 4; ++i) {
    for (int j = 0; j < anspos[i]; ++j) {
      res.push_back(v[i][j].id);
    }
  }
  for (auto y : res) printf("%d ", y);
  return 0;
}
