#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1);
const double eps = 1e-9;
const int inf = 2000000000;
const long long infLL = 9000000000000000000;
int dx[] = {0, 0, +1, -1};
int dy[] = {+1, -1, 0, 0};
template <typename first, typename second>
ostream &operator<<(ostream &os, const pair<first, second> &p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  os << "{";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "}";
}
template <typename T>
ostream &operator<<(ostream &os, const set<T> &v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename T>
ostream &operator<<(ostream &os, const multiset<T> &v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename first, typename second>
ostream &operator<<(ostream &os, const map<first, second> &v) {
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
void faltu(T arg, const hello &...rest) {
  cerr << arg << ' ';
  faltu(rest...);
}
const int mx = 5e3 + 1;
int ar[mx], ar2[mx], t[mx], l[mx], r[mx], d[mx], diff[mx];
bool chk(int m) {
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) ar2[j] += d[i];
    } else {
      int mx = ar2[l[i]];
      for (int j = l[i] + 1; j <= r[i]; j++) mx = max(ar2[j], mx);
      if (mx != d[i]) return 0;
    }
  }
  return 1;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) ar[i] = inf;
  for (int i = 1; i <= m; i++) cin >> t[i] >> l[i] >> r[i] >> d[i];
  for (int i = m; i >= 1; i--) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        if (ar[j] != inf) ar[j] -= d[i];
      }
    } else {
      bool ok = 1;
      for (int j = l[i]; j <= r[i]; j++) {
        if (ar[j] >= d[i]) {
          ar[j] = d[i];
          ok = 0;
        }
      }
      if (ok) return cout << "NO" << '\n', 0;
    }
  }
  for (int i = 1; i <= n; i++) {
    if (ar[i] == inf) ar[i] = 0;
    ar2[i] = ar[i];
  }
  if (chk(m)) {
    cout << "YES" << '\n';
    for (int i = 1; i <= n; i++) cout << ar[i] << " ";
    cout << '\n';
  } else
    cout << "NO" << '\n';
  return 0;
}
