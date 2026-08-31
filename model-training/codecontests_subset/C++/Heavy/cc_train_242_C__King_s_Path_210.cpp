#include <bits/stdc++.h>
#pragma GCC optimize(2)
#pragma GCC optimize(3)
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("avx,avx2,fma")
using namespace std;
long long power(long long a, long long b) {
  long long res = 1;
  a = a % 998244353;
  while (b > 0) {
    if (b & 1) {
      res = (res * a) % 998244353;
    }
    a = (a * a) % 998244353;
    b >>= 1;
  }
  return res;
}
long long fermat_inv(long long y) { return power(y, 998244353 - 2); }
long long gcd(long long a, long long b) { return (b == 0) ? a : gcd(b, a % b); }
const long long dx[] = {-1, 0, 1, 0, -1, 1, 1, -1};
const long long dy[] = {0, 1, 0, -1, 1, 1, -1, -1};
bool valid(long long x, long long y) {
  if (x < 1 || x > (long long)1e9 || y < 1 || y > (long long)1e9) return false;
  return true;
}
void solve() {
  long long x, y, x1, y1;
  cin >> x >> y >> x1 >> y1;
  long long qu;
  cin >> qu;
  map<pair<long long, long long>, long long> m;
  while (qu--) {
    long long row, l, r;
    cin >> row >> l >> r;
    for (long long i = l; i <= r; i++) m[{row, i}] = 1;
  }
  queue<pair<long long, long long> > q;
  q.push({x, y});
  map<pair<long long, long long>, long long> dep, vis;
  dep[{x, y}] = 0;
  vis[{x, y}] = 1;
  while (!q.empty()) {
    long long xx = q.front().first;
    long long yy = q.front().second;
    q.pop();
    if (xx == x1 && yy == y1) {
      cout << dep[{xx, yy}];
      return;
    }
    for (long long i = 0; i < 8; i++) {
      long long xn = xx + dx[i];
      long long yn = yy + dy[i];
      if (valid(xn, yn) && m[{xn, yn}] == 1 && vis[{xn, yn}] == 0) {
        vis[{xn, yn}] = 1;
        q.push({xn, yn});
        dep[{xn, yn}] = dep[{xx, yy}] + 1;
      }
    }
  }
  cout << "-1";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long T = 1;
  while (T--) {
    solve();
  }
  return 0;
}
