#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, minimal, minimal2, ans, ans1;
int main() {
  cin >> n;
  while (n > 0) {
    cin >> a >> b >> c;
    n--;
    int b1 = b, c1 = c;
    minimal = min(a, b / 2);
    b -= minimal * 2;
    ans += minimal + (minimal * 2);
    minimal2 = min(b, c / 2);
    ans += minimal2 + (minimal2 * 2);
    minimal = min(b1, c1 / 2);
    ans1 += minimal + (minimal * 2);
    b1 -= minimal;
    minimal2 = min(a, b1 / 2);
    ans1 += minimal2 + (minimal2 * 2);
    (ans > ans1) ? cout << ans << endl : cout << ans1 << endl;
    ans = 0;
    ans1 = 0;
  }
  return 0;
}
