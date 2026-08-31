#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using uint = unsigned int;
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862;
const int inf_int = 1e9 + 5;
const ll inf_ll = 1e18 + 5;
const int NMax = 1e5 + 5;
int main() {
  cin.sync_with_stdio(false);
  cin.tie(0);
  int x0, y0, x1, y1, N;
  cin >> x0 >> y0 >> x1 >> y1 >> N;
  map<pair<int, int>, bool> allowed;
  for (int i = 1; i <= N; ++i) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; ++j) {
      allowed[{r, j}] = true;
    }
  }
  struct elem {
    int x, y, steps;
  };
  const int dx[8] = {-1, -1, -1, 0, 0, +1, +1, +1};
  const int dy[8] = {-1, 0, +1, -1, +1, -1, 0, +1};
  queue<elem> Q;
  map<pair<int, int>, bool> vis;
  vis[{x0, y0}] = true;
  Q.push({x0, y0, 0});
  while (Q.size()) {
    auto e = Q.front();
    Q.pop();
    if (e.x == x1 && e.y == y1) {
      cout << e.steps << '\n';
      return 0;
    }
    for (int k = 0; k < 8; ++k) {
      int nx = e.x + dx[k];
      int ny = e.y + dy[k];
      if (!allowed[{nx, ny}] || vis[{nx, ny}]) {
        continue;
      }
      vis[{nx, ny}] = true;
      Q.push({nx, ny, e.steps + 1});
    }
  }
  cout << "-1\n";
  return 0;
}
