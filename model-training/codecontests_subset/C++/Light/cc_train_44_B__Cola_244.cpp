#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long int n, a, b, c, c1 = 0;
  cin >> n >> a >> b >> c;
  for (long long int i = 0; i <= b; i++) {
    for (long long int j = 0; j <= c; j++) {
      long long int x = 2 * (n - (2 * j) - i);
      if (x >= 0 && x <= a) c1++;
    }
  }
  cout << c1;
}
