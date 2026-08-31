#include <bits/stdc++.h>
using namespace std;
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  os << '{';
  string sep;
  for (const auto &x : v) os << sep << x, sep = ", ";
  return os << '}';
}
template <typename T>
ostream &operator<<(ostream &os, const set<T> &v) {
  os << '{';
  string sep;
  for (const auto &x : v) os << sep << x, sep = ", ";
  return os << '}';
}
template <typename T, size_t size>
ostream &operator<<(ostream &os, const array<T, size> &arr) {
  os << '{';
  string sep;
  for (const auto &x : arr) os << sep << x, sep = ", ";
  return os << '}';
}
template <typename A, typename B>
ostream &operator<<(ostream &os, const pair<A, B> &p) {
  return os << '(' << p.first << ", " << p.second << ')';
}
template <typename A, typename B>
ostream &operator<<(ostream &os, const map<A, B> &v) {
  os << '{';
  string sep;
  for (const auto &x : v) os << sep << x, sep = ", ";
  return os << '}';
}
void dbg_out() { cerr << endl; }
template <typename Head, typename... Tail>
void dbg_out(Head H, Tail... T) {
  cerr << ' ' << H;
  dbg_out(T...);
}
mt19937 mt_rng(chrono::steady_clock::now().time_since_epoch().count());
long long rand(long long a, long long b) {
  return uniform_int_distribution<long long>(a, b)(mt_rng);
}
template <long long D, typename T>
struct vec : public vector<vec<D - 1, T>> {
  static_assert(D >= 1, "Dimensions invalid");
  template <typename... Args>
  vec(long long n = 0, Args... args)
      : vector<vec<D - 1, T>>(n, vec<D - 1, T>(args...)) {}
};
template <typename T>
struct vec<1, T> : public vector<T> {
  vec(long long n = 0, const T &val = T()) : vector<T>(n, val) {}
};
template <class T>
bool cmin(T &a, const T &b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool cmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
const long long N = 1e5, inf = 1e18;
const long long MAGIC = sqrt(N);
long long n, ans;
vector<long long> y_cords[N + 1];
vector<long long> large_xs;
bool have(long long x, long long y) {
  vector<long long> &look = y_cords[x];
  long long id = lower_bound((look).begin(), (look).end(), y) - look.begin();
  if (id == (long long)(look.size())) return false;
  return look[id] == y;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (long long i = (1); i <= (n); i++) {
    long long x, y;
    cin >> x >> y;
    y_cords[x].push_back(y);
  }
  for (long long x = (0); x <= (N); x++)
    sort((y_cords[x]).begin(), (y_cords[x]).end());
  for (long long x = (0); x <= (N); x++) {
    if ((long long)(y_cords[x].size()) <= MAGIC) {
      for (long long i = 0; i < (long long)(y_cords[x].size()); i++) {
        for (long long j = i + 1; j < (long long)(y_cords[x].size()); j++) {
          long long y1 = y_cords[x][i];
          long long y2 = y_cords[x][j];
          long long x2 = x;
          long long x1 = x - (y2 - y1);
          if (x1 >= 0) {
            ans += have(x1, y1) && have(x1, y2);
          }
          x1 = x + (y2 - y1);
          if (x1 <= N && (long long)(y_cords[x1].size()) > MAGIC) {
            ans += have(x1, y1) && have(x1, y2);
          }
        }
      }
    } else {
      large_xs.push_back(x);
    }
  }
  for (long long i = 0; i < (long long)(large_xs.size()); i++) {
    for (long long j = i + 1; j < (long long)(large_xs.size()); j++) {
      long long x1 = large_xs[i];
      long long x2 = large_xs[j];
      for (long long y1 : y_cords[x1]) {
        long long len = x2 - x1;
        long long y2 = y1 + len;
        ans += have(x2, y1) && have(x2, y2) && have(x1, y2);
      }
    }
  }
  cout << ans << "\n";
}
