#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")
#pragma GCC optimize("unroll-loops")
using namespace std;
const double eps = 1e-9;
const int inf = 2000000000;
const long long infLL = 9000000000000000000;
template <typename first, typename second>
ostream& operator<<(ostream& os, const pair<first, second>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  os << "{";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ",";
    os << *it;
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const multiset<T>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename first, typename second>
ostream& operator<<(ostream& os, const map<first, second>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << it->first << " = " << it->second;
  }
  return os << "]";
}
void faltu() { cerr << '\n'; }
template <typename T>
void faltu(T a[], int n) {
  for (int i = 0; i < n; ++i) cerr << a[i] << ' ';
  cerr << '\n';
}
template <typename T, typename... hello>
void faltu(T arg, const hello&... rest) {
  cerr << arg << ' ';
  faltu(rest...);
}
bitset<405> bt[26][405];
bitset<405> result[405];
bitset<405> one;
string s[405], p[405];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  one = ~one;
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) cin >> s[i];
  int r, c;
  cin >> r >> c;
  for (int i = 0; i < r; ++i) cin >> p[i];
  for (int i = 0; i < n; ++i) result[i] = ~result[i];
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      bt[s[i][j] - 'a'][i][j] = 1;
    }
  }
  bitset<405> temp;
  for (int i = 0; i < r; ++i) {
    for (int j = 0; j < c; ++j) {
      char ch = p[i][j];
      if (ch == '?') continue;
      int idx = ch - 'a';
      int shiftx = j % m;
      int shifty = i % n;
      for (int k = 0, z = shifty; k < n; ++k, z = (z + 1) % n) {
        temp = (bt[idx][z] >> shiftx) | ((bt[idx][z] << (m - shiftx)));
        result[k] &= temp;
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      cout << result[i][j];
    }
    cout << '\n';
  }
}
