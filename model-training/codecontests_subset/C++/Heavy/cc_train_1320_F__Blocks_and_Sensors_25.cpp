#include <bits/stdc++.h>
using namespace std;
template <typename T>
void maxtt(T& t1, T t2) {
  t1 = max(t1, t2);
}
template <typename T>
void mintt(T& t1, T t2) {
  t1 = min(t1, t2);
}
bool debug = 0;
int n, m, k;
string direc = "RDLU";
const long long MOD2 = (long long)1000000007 * (long long)1000000007;
long long ln, lk, lm;
void etp(bool f = 0) {
  puts(f ? "YES" : "NO");
  exit(0);
}
void addmod(int& x, int y, int mod = 1000000007) {
  x += y;
  if (x >= mod) x -= mod;
  if (x < 0) x += mod;
  assert(x >= 0 && x < mod);
}
void et(int x = -1) {
  printf("%d\n", x);
  exit(0);
}
long long fastPow(long long x, long long y, int mod = 1000000007) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = (x * ans) % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
long long gcd1(long long x, long long y) { return y ? gcd1(y, x % y) : x; }
const int dx[6] = {1, -1, 0, 0, 0, 0};
const int dy[6] = {0, 0, 1, -1, 0, 0};
const int dz[6] = {0, 0, 0, 0, 1, -1};
int col[200135];
vector<int> vp[200135];
int gid(int x, int y, int z) { return (x - 1) * m * k + (y - 1) * k + z; }
inline void wk(int dir, int C, int x, int y, int z) {
  if (x < 1 || x > n || y < 1 || y > m || z < 1 || z > k) {
    if (C == 0) return;
    et();
  }
  int id = gid(x, y, z);
  if (col[id] == 0)
    wk(dir, C, dx[dir] + x, dy[dir] + y, dz[dir] + z);
  else if (col[id] < 0) {
    col[id] = C;
    if (C == 0)
      wk(dir, C, dx[dir] + x, dy[dir] + y, dz[dir] + z);
    else
      vp[id].push_back(dir);
  } else if (col[id] != C) {
    int cc = col[id];
    col[id] = 0;
    for (int dir : vp[id]) wk(dir, cc, dx[dir] + x, dy[dir] + y, dz[dir] + z);
    wk(dir, C, dx[dir] + x, dy[dir] + y, dz[dir] + z);
  } else
    vp[id].push_back(dir);
}
void fmain(int tid) {
  scanf("%d%d%d", &n, &m, &k);
  memset(col, -1, sizeof col);
  int x;
  for (int(i) = 1; (i) <= (int)(m); (i)++)
    for (int(j) = 1; (j) <= (int)(k); (j)++) {
      scanf("%d", &x);
      wk(0, x, 1, i, j);
    }
  for (int(i) = 1; (i) <= (int)(m); (i)++)
    for (int(j) = 1; (j) <= (int)(k); (j)++) {
      scanf("%d", &x);
      wk(1, x, n, i, j);
    }
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    for (int(j) = 1; (j) <= (int)(k); (j)++) {
      scanf("%d", &x);
      wk(2, x, i, 1, j);
    }
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    for (int(j) = 1; (j) <= (int)(k); (j)++) {
      scanf("%d", &x);
      wk(3, x, i, m, j);
    }
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    for (int(j) = 1; (j) <= (int)(m); (j)++) {
      scanf("%d", &x);
      wk(4, x, i, j, 1);
    }
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    for (int(j) = 1; (j) <= (int)(m); (j)++) {
      scanf("%d", &x);
      wk(5, x, i, j, k);
    }
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    for (int(j) = 1; (j) <= (int)(m); (j)++)
      for (int(z) = 1; (z) <= (int)(k); (z)++) {
        int c = col[gid(i, j, z)];
        if (c < 0) c = 0;
        printf("%d ", c);
      }
}
int main() {
  int t = 1;
  for (int(i) = 1; (i) <= (int)(t); (i)++) {
    fmain(i);
  }
  return 0;
}
