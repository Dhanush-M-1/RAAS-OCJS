#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q, c;
  cin >> q;
  long long ans = 1, p = 0;
  c = q;
  for (long long int i = 2; i * i <= q; i += 2) {
    while (c % i == 0) {
      if (p < 2) ans *= i;
      p++;
      c /= i;
    }
    if (i == 2) i--;
  }
  if (c != 1) p++;
  if (p >= 3) {
    cout << "1\n" << ans << endl;
  } else if (p == 2) {
    cout << 2 << endl;
  } else if (p == 1) {
    cout << "1\n0" << endl;
  } else
    cout << "1\n0" << endl;
  return 0;
}
