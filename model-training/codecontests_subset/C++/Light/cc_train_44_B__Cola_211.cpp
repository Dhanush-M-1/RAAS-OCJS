#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  double a, b, c;
  long long n, ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i++)
    for (int k = 0; k <= b; k++) {
      double sum = n - 0.5 * i - k;
      if (sum >= 0) {
        sum /= 2.0;
        if (!(sum > (long long)sum) && sum <= c) {
          ans += 1;
        }
      }
    }
  cout << ans;
  return 0;
}
