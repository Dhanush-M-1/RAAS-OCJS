#include <bits/stdc++.h>
const int N = (int)1e6 + 123;
const long long inf = (long long)1e18 + 123;
const double eps = 1e-6;
using namespace std;
int sum = 0;
int main() {
  int c1, c2, c3, c4, c5;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  sum = c1 + c2 + c3 + c4 + c5;
  if (sum == 0) {
    cout << -1;
  } else if (sum % 5 == 0) {
    cout << sum / 5;
  } else if (sum != 0) {
    cout << -1;
  }
  return 0;
}
