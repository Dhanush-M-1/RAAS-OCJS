#include <bits/stdc++.h>
using namespace std;
const long long M = 1e9 + 7;
const long long INF = 1e9;
inline long long pwr(long long base, long long n, long long m) {
  long long ans = 1;
  while (n > 0) {
    if (n % 2 == 1) ans = (ans * base) % m;
    base = (base * base) % m;
    n /= 2;
  }
  return ans;
}
const int N = 1e5 + 10;
int a, b, x, y, row, l, r;
int dx[] = {-1, -1, 1, 1, 1, -1, 0, 0};
int dy[] = {-1, 1, -1, 1, 0, 0, -1, 1};
map<pair<int, int>, int> cost;
map<pair<int, int>, int> good;
int bfs() {
  deque<pair<int, int> > mv;
  mv.push_back(make_pair(a, b));
  cost[make_pair(a, b)] = 1;
  while (!mv.empty()) {
    pair<int, int> temp = mv.front();
    mv.pop_front();
    int xx = temp.first;
    int yy = temp.second;
    int c = cost[make_pair(xx, yy)];
    if (xx == x && yy == y) return c;
    for (int k = 0; k < 8; k++) {
      int i1 = xx + dx[k], j1 = yy + dy[k];
      long long q = cost[make_pair(i1, j1)];
      if (good[make_pair(i1, j1)] && (q == 0 || q > c + 1)) {
        cost[make_pair(i1, j1)] = c + 1;
        mv.push_back(make_pair(i1, j1));
      }
    }
  }
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> a >> b >> x >> y;
  cin >> n;
  while (n--) {
    cin >> row >> l >> r;
    for (int col = l; col < r + 1; col++) good[make_pair(row, col)] = 1;
  }
  cout << bfs() - 1;
  return 0;
}
