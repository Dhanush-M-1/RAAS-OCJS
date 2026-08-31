#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  long long ans = 0, n, a, b, c;
  cin >> n >> a >> b >> c;
  for (long long i = 0; i <= c; i++) {
    for (long long j = 0; j <= b; j++) {
      long long k = (n - 2 * i - j) * 2;
      if (k >= 0 & k <= a) ans++;
    }
  }
  cout << ans << endl;
}
