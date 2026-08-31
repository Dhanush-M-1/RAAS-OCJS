#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int ans = (1LL << 30) - 1LL;
  long long int a, b, c;
  cin >> a >> b >> c;
  long long int all_need = c * a;
  for (int k = 29; k >= 0; --k) {
    long long int wt = ans ^ (1LL << k);
    long long int no_int = 1LL;
    long long int dw = (wt * b);
    long long int dn = a;
    while (true) {
      if (dw >= all_need) break;
      if (dn > dw) {
        no_int = 0LL;
        break;
      }
      dw += b;
      dn += a;
    }
    ans ^= (no_int) << k;
  }
  cout << max(ans - 1LL, 1LL) << endl;
  return 0;
}
