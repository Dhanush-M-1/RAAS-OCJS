#include <bits/stdc++.h>
using namespace std;
int II;
long long I_O;
char CC, SS[20];
const int N = 1e5 + 4;
inline long long read() {
  II = 1, I_O = 0;
  while (!isdigit(CC = getchar()))
    if (CC == '-') II = -1;
  while (isdigit(CC)) I_O = I_O * 10 + CC - '0', CC = getchar();
  return I_O * II;
}
inline void wonl() { putchar('\n'); }
inline void wws() {}
inline void dbg() { cout << endl; }
inline void ww(long long k) {
  if (k < 0) putchar('-'), k *= -1;
  II = 0;
  while (k) SS[++II] = k % 10, k /= 10;
  if (!II) SS[++II] = 0;
  while (II) putchar(SS[II--] + '0');
}
inline void ww(pair<long long, long long> p) {
  ww(p.first), putchar(' '), ww(p.second);
}
template <typename T, typename... V>
inline void wonl(T t, V... v) {
  ww(t);
  if (sizeof...(v)) putchar(' ');
  wonl(v...);
}
template <typename T, typename... V>
inline void wws(T t, V... v) {
  ww(t);
  putchar(' ');
  wws(v...);
}
template <typename T, typename... V>
inline void dbg(T t, V... v) {
  cout << ' ' << t;
  dbg(v...);
}
void solve() {
  int x0 = read(), y0 = read();
  int x1 = read(), y1 = read();
  int n = read();
  unordered_map<int, map<int, int>> ma;
  for (int i = 0; i < n; i++) {
    int r = read(), a = read(), b = read();
    ma[r][a] = max(ma[r][a], b);
  }
  std::function<bool(int, int)> isValid;
  isValid = [&](int x, int y) {
    if (ma[x].size() == 0) return false;
    auto it = ma[x].upper_bound(y);
    if (it == ma[x].begin()) return false;
    it--;
    return y <= it->second;
  };
  int dx[8] = {-1, +1, 0, 0, -1, -1, 1, 1};
  int dy[8] = {0, 0, +1, -1, -1, 1, -1, 1};
  map<int, map<int, int>> dist;
  queue<pair<int, int>> q;
  q.push({x0, y0});
  dist[x0][y0] = 0;
  while (!q.empty()) {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    for (int dir = 0; dir < 8; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      if (isValid(nx, ny) && dist[nx].find(ny) == dist[nx].end()) {
        dist[nx][ny] = dist[x][y] + 1;
        q.push({nx, ny});
      }
    }
  }
  if (dist[x1].find(y1) == dist[x1].end())
    wonl(-1);
  else
    wonl(dist[x1][y1]);
}
int main() {
  solve();
  return 0;
}
