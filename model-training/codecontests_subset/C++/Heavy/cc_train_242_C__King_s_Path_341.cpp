#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y) {
  long long res = 1LL;
  x = x % 1000000007;
  while (y > 0) {
    if (y & 1) res = (res * x) % 1000000007;
    y = y >> 1;
    x = (x * x) % 1000000007;
  }
  return res % 1000000007;
}
long long inv(long long n) { return power(n, 1000000007 - 2) % 1000000007; }
long long isprime(long long n) {
  if (n < 2) return 0;
  long long i;
  for (i = 2; i * i <= n; i++)
    if (n % i == 0) return 0;
  return 1;
}
void files() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
long long egcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  }
  long long x1, y1;
  long long g = egcd(b, a % b, x1, y1);
  x = y1;
  y = x1 - (a / b) * y1;
  return g;
}
const long long N = 2e5 + 10;
long long p, q, r, s, j;
long long dx[] = {0, 0, 1, 1, -1, -1, 1, -1};
long long dy[] = {1, -1, 1, -1, 1, -1, 0, 0};
map<long long, map<long long, long long>> mp, dis, vis;
void solve() {
  cin >> p >> q >> r >> s;
  long long n;
  long long i, r1, c1, c2;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> r1 >> c1 >> c2;
    for (j = c1; j <= c2; j++) {
      mp[r1][j] = 1;
      dis[r1][j] = 1e17;
      vis[r1][j] = 0;
    }
  }
  queue<pair<long long, long long>> qi;
  qi.push({p, q});
  vis[p][q] = 1;
  dis[p][q] = 0;
  while (qi.size()) {
    auto f = qi.front();
    qi.pop();
    long long x, y;
    x = f.first;
    y = f.second;
    for (i = 0; i < 8; i++) {
      long long nx, ny;
      nx = x + dx[i];
      ny = y + dy[i];
      if (vis[nx][ny] == 0 && mp[nx][ny]) {
        vis[nx][ny] = 1;
        dis[nx][ny] = 1 + dis[x][y];
        qi.push({nx, ny});
      }
    }
  }
  if (!(dis[r][s] < 1e17)) dis[r][s] = -1;
  cout << dis[r][s] << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  while (t--) {
    solve();
  }
}
