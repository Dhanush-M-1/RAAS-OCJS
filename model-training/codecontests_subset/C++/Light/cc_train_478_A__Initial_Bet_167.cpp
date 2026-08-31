#include <bits/stdc++.h>
using namespace std;
template <class T>
T max(T a, T b, T c) {
  return max(a, max(b, c));
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  long long sum = a + b + c + d + e;
  if (sum == 0) {
    cout << "-1\n";
    return 0;
  }
  if (sum % 5 == 0) {
    cout << sum / 5 << "\n";
  } else {
    cout << "-1\n";
  }
  return 0;
}
