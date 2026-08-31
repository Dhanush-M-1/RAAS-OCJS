#include <bits/stdc++.h>
using namespace std;
void _print(long long t) { cerr << t; }
void _print(int t) { cerr << t; }
void _print(string t) { cerr << t; }
void _print(char t) { cerr << t; }
void _print(long double t) { cerr << t; }
void _print(double t) { cerr << t; }
void _print(unsigned long long t) { cerr << t; }
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
  _print(p.first);
  cerr << ",";
  _print(p.second);
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
template <typename T, typename T1>
T amax(T &a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T &a, T1 b) {
  if (b < a) a = b;
  return a;
}
const int N = 1e9 + 1;
const int x = 201;
int a[200][200];
void solve() {
  int n;
  cin >> n;
  string s[n];
  for (int i = 0; i < n; ++i) {
    cin >> s[i];
  }
  int a = s[0][1], b = s[1][0];
  int c = s[n - 1][n - 2], d = s[n - 2][n - 1];
  vector<pair<int, int>> v;
  if (a == b) {
    if (a == c) v.push_back({n, n - 1});
    if (a == d) v.push_back({n - 1, n});
  } else if (c == d) {
    if (c == a) v.push_back({1, 2});
    if (c == b) v.push_back({2, 1});
  } else {
    v.push_back({2, 1});
    if (a == c) v.push_back({n, n - 1});
    if (a == d) v.push_back({n - 1, n});
  }
  cout << ((int)(v).size()) << '\n';
  for (auto x : v) cout << x.first << " " << x.second << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
