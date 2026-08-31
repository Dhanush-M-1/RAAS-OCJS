#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T1, class T2>
ostream& operator<<(ostream& s, pair<T1, T2> P) {
  return s << '<' << P.first << ", " << P.second << '>';
}
template <class T>
ostream& operator<<(ostream& s, vector<T> P) {
  for (long long i = 0; i < P.size(); ++i) {
    if (i > 0) {
      s << " ";
    }
    s << P[i];
  }
  return s;
}
template <class T>
ostream& operator<<(ostream& s, vector<vector<T> > P) {
  for (long long i = 0; i < P.size(); ++i) {
    s << endl << P[i];
  }
  return s << endl;
}
template <class T>
ostream& operator<<(ostream& s, set<T> P) {
  for (__typeof__((P).begin()) it = (P).begin(); it != (P).end(); ++it) {
    s << "<" << *it << "> ";
  }
  return s << endl;
}
template <class T1, class T2>
ostream& operator<<(ostream& s, map<T1, T2> P) {
  for (__typeof__((P).begin()) it = (P).begin(); it != (P).end(); ++it) {
    s << "<" << it->first << "->" << it->second << "> ";
  }
  return s << endl;
}
template <class T>
void show(vector<T> v) {
  for (long long i = 0; i < v.size(); i++) {
    cerr << v[i] << " ";
  }
  cerr << "\n";
}
void solve() {
  long long n, m;
  cin >> n >> m;
  vector<long long> a(n), b(m);
  vector<long long> v(10010, 0);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    v[a[i]]++;
  }
  bool ok = false;
  long long x;
  for (long long i = 0; i < m; i++) {
    cin >> b[i];
    if (v[b[i]] > 0) {
      ok = true;
      x = b[i];
    }
  }
  if (ok) {
    cout << "YES" << endl;
    cout << 1 << " " << x << endl;
  } else {
    cout << "NO" << endl;
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  long long t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
