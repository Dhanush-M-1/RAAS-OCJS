#include <bits/stdc++.h>
using namespace std;
inline int Int() {
  int x;
  cin >> x;
  return x;
}
inline long long Long() {
  long long x;
  cin >> x;
  return x;
}
inline float Float() {
  float x;
  cin >> x;
  return x;
}
inline double Double() {
  double x;
  cin >> x;
  return x;
}
inline void Yes() { cout << "Yes" << endl; }
inline void No() { cout << "No" << endl; }
inline void YES() { cout << "YES" << endl; }
inline void NO() { cout << "NO" << endl; }
const int N = (int)2e5 + 5;
const int maxN = (int)1e6 + 6;
const long long Mod = (long long)1e9 + 7;
const int inf = (int)2e9;
const long long Inf = (long long)1e18;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL);
  int t, q;
  cin >> t;
  for (q = 1; q <= t; q++) {
    long long n, i, x, c = 0, c1 = 1, c2 = 1, c3 = 1;
    cin >> n;
    long long a[n], b[n];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      b[i] = a[i];
    }
    sort(b, b + n);
    for (i = n - 1; i >= 2; i--) {
      if (b[0] + b[1] <= b[i]) {
        x = b[i];
        c = 1;
        break;
      }
    }
    if (c) {
      vector<long long> v;
      for (i = 0; i < n; i++) {
        if (v.size() == 3) break;
        if (b[0] == a[i] and c1) {
          v.push_back(i + 1);
          c1 = 0;
        } else if (b[1] == a[i] and c2) {
          v.push_back(i + 1);
          c2 = 0;
        } else if (x == a[i] and c3) {
          v.push_back(i + 1);
          c3 = 0;
        }
      }
      sort(v.begin(), v.end());
      for (i = 0; i < 3; i++) cout << v[i] << " ";
      cout << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
