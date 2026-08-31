#include <bits/stdc++.h>
using namespace std;
constexpr double pi = 3.14159265358979323846;
int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
map<pair<long long, long long>, long long> bound;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  while (n--) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (; a <= b; ++a) {
      bound[{r, a}] = -1;
    }
  }
  queue<pair<long long, long long>> q;
  q.push({x0, y0});
  bound[{x0, y0}] = 0;
  while (!q.empty()) {
    long long x = q.front().first;
    long long y = q.front().second;
    pair<long long, long long> u = {x, y};
    q.pop();
    for (int i(0); i < 8; ++i) {
      long long mx = x + dx[i];
      long long my = y + dy[i];
      pair<long long, long long> p = {mx, my};
      if (bound.count(p) && bound[p] == -1) {
        bound[p] = bound[u] + 1;
        q.push(p);
      }
    }
  }
  cout << bound[{x1, y1}];
  cout << "\n";
  return 0;
}
