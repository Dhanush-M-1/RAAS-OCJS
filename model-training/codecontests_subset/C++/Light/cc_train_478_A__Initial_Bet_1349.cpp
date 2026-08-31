#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long t = 1;
  while (t--) {
    long long sum = 0;
    for (long long i = 0; i < 5; i++) {
      long long c;
      cin >> c;
      sum += c;
    }
    if (sum % 5 != 0 || sum <= 0)
      cout << "-1\n";
    else
      cout << sum / 5 << "\n";
  }
}
