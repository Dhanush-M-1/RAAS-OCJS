#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long n;
  cin >> n;
  long long div1 = -1, div2 = -1;
  for (long long i = 2; i <= sqrt(n); ++i) {
    if (n % i == 0) {
      if (div1 == -1) {
        div1 = i;
        if (n / i % i == 0) {
          div2 = i;
          break;
        }
      } else {
        div2 = i;
        break;
      }
    }
  }
  if (div1 == -1)
    cout << "1\n0";
  else if (div2 == -1 || div1 * div2 == n) {
    cout << "2\n";
  } else {
    cout << "1\n" << div1 * div2 << "\n";
  }
  return 0;
}
