#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k;
  cin >> n >> k;
  long long x, a, b, ans = 0;
  cin >> x;
  while (n--) {
    cin >> a;
    if (x - a - k > ans) ans = (x - a - k);
    x = a;
  }
  cout << ans;
  return 0;
}
