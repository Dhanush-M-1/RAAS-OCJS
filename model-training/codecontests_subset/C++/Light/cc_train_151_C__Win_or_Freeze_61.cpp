#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long q;
  cin >> q;
  long long temp = q;
  long long count = 0;
  long long ans = 1;
  for (long long i = 2; i <= sqrt(q); i++) {
    while (temp % i == 0 && count != 2) {
      temp /= i;
      count++;
      ans *= i;
    }
    if (count == 2) break;
  }
  if (temp == q) {
    cout << 1 << endl << 0;
    return 0;
  }
  if (ans == q && count == 2) {
    cout << 2 << endl;
    return 0;
  }
  if (count == 2) {
    cout << 1 << endl << ans;
    return 0;
  }
  if (count == 1 && temp != q) {
    cout << 2 << endl;
    return 0;
  }
}
