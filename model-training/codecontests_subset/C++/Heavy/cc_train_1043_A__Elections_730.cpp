#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
inline bool chkmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
template <typename T>
inline bool smin(T &a, const T &b) {
  return a > b ? a = b : a;
}
template <typename T>
inline bool smax(T &a, const T &b) {
  return a < b ? a = b : a;
}
const int N = (int)205, mod = (int)0;
int a[N];
int main() {
  int n, mx = 0, sum = 0;
  cin >> n;
  for (int j = 0; j < n; ++j) {
    cin >> a[j];
    mx = max(mx, a[j]);
    sum += a[j];
  }
  for (int k = mx; k < N; ++k) {
    if (k * n - sum > sum) {
      cout << k << endl;
      return 0;
    }
  }
}
