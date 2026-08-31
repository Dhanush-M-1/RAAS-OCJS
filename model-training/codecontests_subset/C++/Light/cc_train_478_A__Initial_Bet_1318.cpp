#include <bits/stdc++.h>
using namespace std;
template <typename T>
T ABS(const T& val) {
  return val < 0 ? -val : val;
}
int main() {
  std::ios_base::sync_with_stdio(false);
  int c[5];
  while (cin >> c[0] >> c[1] >> c[2] >> c[3] >> c[4]) {
    int sum = 0;
    for (int i = 0; i < 5; ++i) {
      sum += c[i];
    }
    if (sum % 5 == 0 && sum / 5 != 0) {
      cout << sum / 5 << "\n";
    } else {
      cout << -1 << "\n";
    }
  }
  return 0;
}
