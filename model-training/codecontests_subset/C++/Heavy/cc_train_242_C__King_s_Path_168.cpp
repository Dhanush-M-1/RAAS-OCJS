#include <bits/stdc++.h>
using namespace std;
int solve() {
  int x, y, p, f;
  cin >> x >> y >> p >> f;
  int n;
  cin >> n;
  set<pair<int, int>> allowed;
  while (n--) {
    int r;
    cin >> r;
    int start, end;
    cin >> start >> end;
    for (int c = start; c <= end; c++) {
      allowed.insert({r, c});
    }
  }
  struct node {
    int i, j, steps;
    node(int _i, int _j, int _steps) {
      i = _i;
      j = _j;
      steps = _steps;
    }
  };
  set<pair<int, int>> visi;
  visi.insert({x, y});
  queue<node> q;
  q.push(node(x, y, 0));
  int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
  int dy[] = {0, 0, 1, -1, 1, 1, -1, -1};
  while (!q.empty()) {
    struct node tp = q.front();
    q.pop();
    int i = tp.i;
    int j = tp.j;
    int steps = tp.steps;
    if (i == p && j == f) return steps;
    for (int ind = 0; ind < 8; ind++) {
      int newi = i + dx[ind];
      int newj = j + dy[ind];
      if (allowed.find({newi, newj}) != allowed.end() &&
          visi.find({newi, newj}) == visi.end()) {
        visi.insert({newi, newj});
        q.push(node(newi, newj, steps + 1));
      }
    }
  }
  return -1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << solve();
  return 0;
}
