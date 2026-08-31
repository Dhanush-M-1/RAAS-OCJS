#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int a, b, c;
  cin >> a >> b >> c;
  int l = 1, r = a * c;
  int sol = INT_MAX, ans = -1;
  while (l <= r) {
    int mid = l + (r - l) / 2;
    int cost = mid * b + (c * b);
    if (cost > a * c) {
      r = mid - 1;
      if (cost < sol) {
        sol = cost, ans = mid;
      }
    } else if (cost < a * c) {
      l = mid + 1;
    } else {
      ans = mid;
      break;
    }
  }
  cout << ans;
  return 0;
}
