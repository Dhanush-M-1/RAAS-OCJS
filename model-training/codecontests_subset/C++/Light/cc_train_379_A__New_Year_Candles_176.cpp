#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long a, b;
  cin >> a >> b;
  long long dem = 0, du = 0;
  while (1) {
    dem += a;
    du += a % b;
    a /= b;
    if (du >= b) {
      a += 1;
      du -= b;
    }
    if (a == 0 && du < b) {
      dem += a;
      break;
    }
  }
  cout << dem;
}
