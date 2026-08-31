#include <bits/stdc++.h>
using namespace std;
bool priz[1000000];
signed main() {
  long long n, x, time = 0;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> x;
    if (x <= 500000) {
      if (x > time) time = x;
    } else {
      if (1000000 - x >= time) time = 1000000 - x + 1;
    }
  }
  cout << time - 1;
}
