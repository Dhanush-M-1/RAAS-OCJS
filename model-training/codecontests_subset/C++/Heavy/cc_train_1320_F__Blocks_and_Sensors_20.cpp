#include <bits/stdc++.h>
using namespace std;
const int N = 200005, dx[] = {1, -1, 0, 0, 0, 0}, dy[] = {0, 0, 1, -1, 0, 0},
          dz[] = {0, 0, 0, 0, 1, -1};
int n, m, kk, a[N];
vector<int> v[N];
inline int id(int x, int y, int z) {
  return (x - 1) * m * kk + (y - 1) * kk + z;
}
inline bool chk(int x, int y, int z) {
  return x >= 1 && x <= n && y >= 1 && y <= m && z >= 1 && z <= kk;
}
void del(int, int, int);
void ins(int d, int x, int y, int z, int c) {
  if (!chk(x, y, z)) {
    if (c) {
      cout << -1 << endl;
      exit(0);
    }
    return;
  }
  int tt = id(x, y, z);
  if (!c) {
    if (a[tt] > 0) del(x, y, z);
    a[tt] = 0;
    ins(d, x + dx[d], y + dy[d], z + dz[d], c);
  } else if (a[tt] == -1 || a[tt] == c) {
    a[tt] = c;
    v[tt].push_back(d);
  } else if (!a[tt])
    ins(d, x + dx[d], y + dy[d], z + dz[d], c);
  else
    del(x, y, z), a[tt] = 0, ins(d, x + dx[d], y + dy[d], z + dz[d], c);
}
void del(int x, int y, int z) {
  int tt = id(x, y, z);
  while (!v[tt].empty()) {
    int d = v[tt].back();
    v[tt].pop_back();
    ins(d, x + dx[d], y + dy[d], z + dz[d], a[tt]);
  }
}
inline int read() {
  int x;
  cin >> x;
  return x;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> kk;
  memset(a, -1, sizeof(a));
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= kk; j++) ins(0, 1, i, j, read());
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= kk; j++) ins(1, n, i, j, read());
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= kk; j++) ins(2, i, 1, j, read());
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= kk; j++) ins(3, i, m, j, read());
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) ins(4, i, j, 1, read());
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) ins(5, i, j, kk, read());
  for (int i = 1; i <= n * m * kk; i++) cout << max(0, a[i]) << ' ';
  return 0;
}
