#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> d;
map<pair<int, int>, bool> valid;
int x11, y11, x2, y2;
int n;
const int N = 1e9 + 3;
deque<pair<int, int> > check;
bool av(int x, int y) {
  if ((x > 0) && (x < N) && (y > 0) && (y < N)) return true;
  return false;
}
void bfs() {
  d[make_pair(x11, y11)] = 0;
  check.push_back(make_pair(x11, y11));
  while (!check.empty()) {
    for (int i = -1; i < 2; ++i)
      for (int j = -1; j < 2; ++j) {
        if ((i == 0) && (j == 0)) continue;
        if (av(check[0].first + i, check[0].second + j))
          if ((d[make_pair(check[0].first + i, check[0].second + j)] == 0) &&
              (valid[make_pair(check[0].first + i, check[0].second + j)])) {
            d[make_pair(check[0].first + i, check[0].second + j)] =
                d[make_pair(check[0].first, check[0].second)] + 1;
            check.push_back(make_pair(check[0].first + i, check[0].second + j));
          }
        if ((check[0].first + i == x2) && (check[0].second + j == y2)) {
          cout << d[make_pair(check[0].first + i, check[0].second + j)];
          return;
        }
      }
    check.pop_front();
  }
  cout << -1;
}
int main() {
  cin >> x11 >> y11 >> x2 >> y2 >> n;
  int r, a, b;
  for (int i = 0; i < n; ++i) {
    cin >> r >> a >> b;
    for (int j = a; j < b + 1; ++j) valid[make_pair(r, j)] = true;
  }
  bfs();
}
