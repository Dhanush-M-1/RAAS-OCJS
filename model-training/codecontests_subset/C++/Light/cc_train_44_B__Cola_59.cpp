#include <bits/stdc++.h>
using namespace std;
const long long N = 25;
int main() {
  long long n, a, b, c, ans, i, j;
  cin >> n >> a >> b >> c;
  ans = 0;
  for (i = 0; i <= c; i++) {
    for (j = 0; j <= b; j++) {
      long long temp = n - j - i * 2;
      ans += (temp >= 0 && temp <= a / 2);
    }
  }
  cout << ans << "\n";
  return 0;
}
