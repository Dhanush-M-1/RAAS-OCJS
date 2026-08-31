#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007, INF = 2000000001;
int dx[] = {0, 1, 0, -1, 1, 1, -1, -1, 0},
    dy[] = {-1, 0, 1, 0, -1, 1, 1, -1, 0};
const double EPS = 1e-9;
long long gcd(long long a, long long b) { return (b != 0) ? gcd(b, a % b) : a; }
long long modpow(long long a, long long x, long long m = mod) {
  int p = 1;
  while (x > 0) {
    if (x & 1 == 1) {
      p = p * a % m;
      --x;
    } else {
      x >>= 1;
      a = a * a % m;
    }
  }
  return p;
}
void z(const string& s, vector<int>& v) {
  int n = s.length();
  for (int i = 1, l = 0, r = 0; i < n; ++i) {
    if (i <= r) v[i] = min(v[i - l], r - i + 1);
    while (i + v[i] < n && s[v[i]] == s[i + v[i]]) ++v[i];
    if (i + v[i] - 1 > r) r = (l = i) + v[i] - 1;
  }
}
void dfs(vector<string>& maze, int x, int y, int& count) {
  if (count > 0) {
    int n = maze.size(), m = maze[0].size();
    for (int d = 0; d < 4 && count > 0; ++d) {
      int tx = x + dx[d], ty = y + dy[d];
      if (ty >= 0 && ty < n && tx >= 0 && tx < m && maze[ty][tx] == '.') {
        maze[ty][tx] = '@';
        --count;
        dfs(maze, tx, ty, count);
      }
    }
  }
}
class P {
 public:
  double n, d;
  P(double dd) : n(dd), d(dd - floor(n)) {}
};
class CP {
 public:
  bool operator()(const P& a, const P& b) const { return a.d < b.d; }
};
void _a() {
  int a, b;
  cin >> a >> b;
  int c = a, left = 0;
  while (a >= b) {
    c += a / b;
    left = a % b;
    a = left + a / b;
    left = 0;
  }
  cout << c;
}
void _b() {}
void _c() {}
void _d() {}
void _e() {}
long long gcdex(long long a, long long b, long long& x, long long& y) {
  if (a == 0) {
    x = 0;
    y = 1;
    return b;
  } else {
    long long x1, y1;
    long long g = gcdex(b % a, a, x1, y1);
    x = y1 - b / a * x1;
    y = x1;
    return g;
  }
}
int main() {
  _a();
  return 0;
}
