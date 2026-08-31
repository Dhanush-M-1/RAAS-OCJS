#include <bits/stdc++.h>
using namespace std;
bool isPrime(long long n) {
  if (n < 2) return 0;
  if (n < 4) return 1;
  if (n % 2 == 0 or n % 3 == 0) return 0;
  for (long long i = 5; i * i <= n; i += 6)
    if (n % i == 0 or n % (i + 2) == 0) return 0;
  return 1;
}
long long modexpo(long long x, long long p) {
  long long res = 1;
  x = x % 998244353;
  while (p) {
    if (p % 2) res = res * x;
    p >>= 1;
    x = x * x % 998244353;
    res %= 998244353;
  }
  return res;
}
long long max(long long a, long long b) { return (a > b ? a : b); }
long long min(long long a, long long b) { return (a < b ? a : b); }
struct node {
  long long u, v;
  node(long long a, long long b) {
    u = a;
    v = b;
  }
};
struct compare {
  bool operator()(const node a, const node b) const {
    if (a.u == b.u) {
      return a.v < b.v;
    }
    return a.u < b.u;
  }
};
map<node, long long, compare> mp, dist, vis;
long long row[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
long long col[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long a, b, c, d;
  cin >> a >> b >> c >> d;
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    for (long long j = y; j <= z; j++) {
      mp[node(x, j)]++;
      dist[node(x, j)] = 2000000000000000000;
    }
  }
  queue<node> q;
  q.push(node(a, b));
  dist[node(a, b)] = 0;
  long long flag = 0;
  while (!q.empty()) {
    auto x = q.front();
    q.pop();
    long long len = dist[x];
    if (x.u == c && x.v == d) {
      flag = 1;
      break;
    }
    for (long long i = 0; i < 8; i++) {
      long long y = x.u + row[i];
      long long z = x.v + col[i];
      if (!vis.count(node(y, z)) && mp.count(node(y, z))) {
        vis[node(y, z)] = 1;
        q.push(node(y, z));
        dist[node(y, z)] = len + 1;
      }
    }
  }
  if (flag == 0) {
    cout << -1 << "\n";
  } else {
    cout << dist[node(c, d)] << "\n";
  }
}
