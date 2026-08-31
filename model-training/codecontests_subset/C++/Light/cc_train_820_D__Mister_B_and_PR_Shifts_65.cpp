#include <bits/stdc++.h>
using namespace std;
int n;
int b[2000010], a[2000010];
int main() {
  cin >> n;
  long long res = 0, ans = 0, ans1 = 0;
  int change = 0;
  for (int i = 1; i <= n; ++i) cin >> a[i];
  for (int i = 1; i <= n; ++i) {
    if (a[i] >= i) {
      res += a[i] - i;
      change--;
      b[a[i] - i]++;
    } else {
      res += i - a[i];
      change++;
      b[a[i] - i + n]++;
    }
  }
  ans = res;
  for (int i = 1; i <= n - 1; ++i) {
    change += b[i - 1];
    change += b[i - 1];
    res += abs(a[n - i + 1] - 1) - abs(a[n - i + 1] - n) + 1;
    change -= 2;
    res += change;
    if (res < ans) ans = res, ans1 = i;
  }
  cout << ans << " " << ans1 << endl;
  return 0;
}
