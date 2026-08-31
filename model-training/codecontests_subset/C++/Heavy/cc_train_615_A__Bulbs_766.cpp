#include <bits/stdc++.h>
using namespace std;
clock_t start;
mt19937_64 rng(chrono::system_clock::now().time_since_epoch().count());
template <typename T>
void _F(const char *name, T arg1) {
  cerr << name << " = " << arg1 << '\n';
}
template <typename T, typename... Args>
void _F(const char *names, T arg1, Args... args) {
  const char *name = strchr(names, ',');
  cerr.write(names, name - names) << " = " << arg1 << '\n';
  _F(name + 2, args...);
}
template <typename T1, typename T2>
istream &operator>>(istream &in, pair<T1, T2> &q) {
  in >> q.first >> q.second;
  return in;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &out, pair<T1, T2> &q) {
  out << q.first << " " << q.second;
  return out;
}
template <typename T1, typename T2>
pair<T1, T2> operator+(pair<T1, T2> p1, pair<T1, T2> p2) {
  return {p1.first + p2.first, p1.second + p2.second};
}
template <typename T1, typename T2>
pair<T1, T2> operator-(pair<T1, T2> p1, pair<T1, T2> p2) {
  return {p1.first - p2.first, p1.second - p2.second};
}
void solve() {
  long long n, m;
  cin >> n >> m;
  set<long long> s;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    for (long long j = 0; j < x; j++) {
      long long y;
      cin >> y;
      s.insert(y);
    }
  }
  if ((long long)((s).size()) == m) {
    cout << "YES" << '\n';
  } else {
    cout << "NO" << '\n';
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  start = clock();
  cout << fixed << setprecision(20);
  for (long long i = 1; i <= t; ++i) {
    solve();
  }
  return 0;
}
