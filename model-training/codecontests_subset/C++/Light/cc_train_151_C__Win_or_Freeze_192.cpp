#include <bits/stdc++.h>
using namespace std;
int main() {
  long long i, q, ans, k = 0;
  cin >> q;
  ans = 1;
  for (i = 2; i * i <= q; ++i) {
    while (i < q && q % i == 0) {
      q /= i;
      ans *= i;
      ++k;
      if (k == 2) {
        cout << 1 << endl << ans << endl;
        return 0;
      }
    }
  }
  if (ans == 1) {
    cout << 1 << endl << 0 << endl;
    return 0;
  }
  cout << 2 << endl;
  return 0;
}
