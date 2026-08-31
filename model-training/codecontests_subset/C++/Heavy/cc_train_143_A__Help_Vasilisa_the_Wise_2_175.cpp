#include <bits/stdc++.h>
using namespace std;
template <typename T, typename T1>
T amax(T a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T a, T1 b) {
  if (b < a) a = b;
  return a;
}
template <typename T>
T amod(T a) {
  if (a < 0) a = -a;
  return a;
}
void solve() {
  long long int c1, c2, d1, d2, r1, r2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  long long int i = (c1 - d2 + r1) % 2 ? -1 : (c1 - d2 + r1) / 2;
  long long int j = (r1 - c1 + d2) % 2 ? -1 : (r1 - c1 + d2) / 2;
  long long int k = (r2 - c2 + d2) % 2 ? -1 : (r2 - c2 + d2) / 2;
  long long int l = (c2 - d2 + r2) % 2 ? -1 : (c2 - d2 + r2) / 2;
  if (i == j || i == k || i == l || j == k || j == l || k == l) {
    cout << "-1";
    return;
  }
  if (i >= 1 && i <= 9 && j >= 1 && j <= 9 && k >= 1 && k <= 9 && l >= 1 &&
      l <= 9) {
    cout << i << " " << j << "\n" << k << " " << l;
  } else {
    cout << "-1";
  }
}
int main() {
  long long int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
