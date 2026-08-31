#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long mod = 1e9 + 7;
const long long inf = 1e18;
const long long dx[8] = {-1, 0, 1, 0, -1, 1, 1, -1},
                dy[8] = {0, 1, 0, -1, 1, 1, -1, -1};
const long long kdx[8] = {-2, -1, 1, 2, 2, 1, -1, -2},
                kdy[8] = {1, 2, 2, 1, -1, -2, -2, -1};
void _print(long long t) { cerr << t; }
void _print(string t) { cerr << t; }
void _print(char t) { cerr << t; }
void _print(long double t) { cerr << t; }
template <class T, class V>
void _print(pair<T, V> p);
template <class T>
void _print(vector<T> v);
template <class T>
void _print(set<T> v);
template <class T, class V>
void _print(map<T, V> v);
template <class T>
void _print(multiset<T> v);
template <class T, class V>
void _print(pair<T, V> p) {
  cerr << "{";
  _print(p.ff);
  cerr << ",";
  _print(p.ss);
  cerr << "}";
}
template <class T>
void _print(vector<T> v) {
  cerr << "[ ";
  for (T i : v) {
    _print(i);
    cerr << " ";
  }
  cerr << "]";
}
template <class T>
void _print(set<T> v) {
  cerr << "[ ";
  for (T i : v) {
    _print(i);
    cerr << " ";
  }
  cerr << "]";
}
template <class T>
void _print(multiset<T> v) {
  cerr << "[ ";
  for (T i : v) {
    _print(i);
    cerr << " ";
  }
  cerr << "]";
}
template <class T, class V>
void _print(map<T, V> v) {
  cerr << "[ ";
  for (auto i : v) {
    _print(i);
    cerr << " ";
  }
  cerr << "]";
}
long long n;
string go(long long a) {
  if (a == 0) return "0";
  string res = "";
  for (; a; a /= n) res += char(a % n + '0');
  reverse(res.begin(), res.end());
  return res;
}
void solve() {
  cin >> n;
  for (long long i = 1; i <= n - 1; ++i) {
    for (long long j = 1; j <= n - 1; ++j) {
      cout << go(i * j) << ' ';
    }
    cout << "\n";
  }
}
int32_t main() {
  clock_t start = clock();
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  for (long long i = 1; i <= t; ++i) {
    solve();
  }
  double duration = (clock() - start) / (double)CLOCKS_PER_SEC;
  cerr << duration << 's' << "\n";
  return 0;
}
