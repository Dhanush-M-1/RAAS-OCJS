#include <bits/stdc++.h>
using namespace std;
template <class T, class S>
ostream& operator<<(ostream& os, const pair<T, S>& v) {
  return os << "(" << v.first << ", " << v.second << ")";
}
template <class T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  os << "[";
  for (int i = int(0); i <= int((sz(v)) - 1); ++i) {
    if (i) os << ", ";
    os << v[i];
  }
  return os << "]";
}
int read_int() {
  int x;
  scanf("%d", &x);
  return x;
}
long long read_ll() {
  long long x;
  scanf("%lld", &x);
  return x;
}
string read_string() {
  string s;
  cin >> s;
  return s;
}
vector<int> read_vi(int n = -1) {
  if (n < 0) scanf("%d", &n);
  vector<int> a(n);
  for (int i = int(0); i <= int((n)-1); ++i) scanf("%d", &a[i]);
  return a;
}
vector<long long> read_vl(int n = -1) {
  if (n < 0) scanf("%d", &n);
  vector<long long> a(n);
  for (int i = int(0); i <= int((n)-1); ++i) scanf("%lld", &a[i]);
  return a;
}
vector<double> read_vd(int n = -1) {
  if (n < 0) scanf("%d", &n);
  vector<double> a(n);
  for (int i = int(0); i <= int((n)-1); ++i) scanf("%lf", &a[i]);
  return a;
}
vector<pair<int, int> > read_vpi(int n = -1) {
  if (n < 0) scanf("%d", &n);
  vector<pair<int, int> > a(n);
  for (int i = int(0); i <= int((n)-1); ++i)
    scanf("%d%d", &a[i].first, &a[i].second);
  return a;
}
vector<pair<long long, long long> > read_vpl(int n = -1) {
  if (n < 0) scanf("%d", &n);
  vector<pair<long long, long long> > a(n);
  for (int i = int(0); i <= int((n)-1); ++i)
    scanf("%lld%lld", &a[i].first, &a[i].second);
  return a;
}
vector<pair<double, double> > read_vpd(int n = -1) {
  if (n < 0) scanf("%d", &n);
  vector<pair<double, double> > a(n);
  for (int i = int(0); i <= int((n)-1); ++i)
    scanf("%lf%lf", &a[i].first, &a[i].second);
  return a;
}
template <class T>
T sorted(T x) {
  sort(x.begin(), x.end());
  return x;
}
template <class T>
T reversed(T x) {
  reverse(x.begin(), x.end());
  return x;
}
template <class T>
bool setmax(T& _a, T _b) {
  if (_a < _b) {
    _a = _b;
    return true;
  }
  return false;
}
template <class T>
bool setmin(T& _a, T _b) {
  if (_b < _a) {
    _a = _b;
    return true;
  }
  return false;
}
template <class T>
T gcd(T _a, T _b) {
  return _b == 0 ? _a : gcd(_b, _a % _b);
}
inline long long powmod(long long a, long long b, long long m) {
  long long r = 1;
  for (; b > 0; b >>= 1, a = a * a % m) {
    if (b & 1) r = r * a % m;
  }
  return r;
}
int main() {
  const int n = read_int();
  vector<vector<int> > es(n);
  for (int x = int(0); x <= int((n)-1); ++x) {
    int y = read_int() - 1;
    if (y >= 0) {
      es[x].push_back(y), es[y].push_back(x);
    }
  }
  vector<vector<bool> > f(n, vector<bool>(2, false));
  vector<vector<vector<int> > > p0(n, vector<vector<int> >(2));
  vector<vector<vector<int> > > p1(n, vector<vector<int> >(2));
  const function<void(int, int)> dfs = [&](int x, int fa) {
    vector<int> ys;
    for (int y : es[x]) {
      if (y != fa) ys.push_back(y);
    }
    vector<vector<int> > g(static_cast<int>((ys).size()) + 1,
                           vector<int>(2, -1));
    g[0][0] = 0;
    for (int i = int(0); i <= int((static_cast<int>((ys).size())) - 1); ++i) {
      const int y = ys[i];
      dfs(y, x);
      for (int j = int(0); j <= int((2) - 1); ++j)
        if (g[i][j] >= 0) {
          for (int k = int(0); k <= int((2) - 1); ++k)
            if (f[y][k]) g[i + 1][j ^ k] = k;
        }
    }
    for (int c = int(0); c <= int((2) - 1); ++c)
      if (g[static_cast<int>((ys).size())][c ^ 1] >= 0) {
        f[x][c] = true;
        for (int i = static_cast<int>((ys).size()) - 1, j = c ^ 1, k; i >= 0;
             j ^= k, --i) {
          k = g[i + 1][j];
          assert(k >= 0);
          (k == 0 ? p0 : p1)[x][c].push_back(ys[i]);
        }
      }
  };
  dfs(0, -1);
  if (!f[0][1]) {
    printf("NO\n");
  } else {
    printf("YES\n");
    const function<void(int, int)> answer = [&](int x, int c) {
      for (int y : p0[x][c]) answer(y, 0);
      printf("%d\n", x + 1);
      for (int y : p1[x][c]) answer(y, 1);
    };
    answer(0, 1);
  }
  return 0;
}
