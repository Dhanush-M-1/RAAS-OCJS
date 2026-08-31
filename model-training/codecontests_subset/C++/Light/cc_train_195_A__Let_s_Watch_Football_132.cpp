#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int t = 0, tend = c * a, ans = 0;
  while (t <= tend) {
    int mid = t + (tend - t) / 2;
    if (b * mid + c * b >= c * a) {
      ans = mid;
      tend = mid - 1;
    } else {
      t = mid + 1;
    }
  }
  cout << ans << endl;
  return 0;
}
