#include <bits/stdc++.h>
using namespace std;
int calc2(int r, int b) {
  static int ans2 = 0;
  static int r2 = 0;
  if (r >= b) {
    ans2 += r / b;
    r2 += r % b;
    calc2(r / b, b);
  } else {
    r2 += r;
    ans2 += r2 / b;
  }
  return ans2;
}
int calc(int a, int b) {
  static int ans = 0;
  static int r = 0;
  if (a >= b) {
    ans += a / b;
    r += a % b;
    calc(a / b, b);
  } else {
    r += a;
    if (r >= a) ans += calc2(r, b);
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int a, b;
  cin >> a >> b;
  cout << calc(a, b) + a;
  return 0;
}
