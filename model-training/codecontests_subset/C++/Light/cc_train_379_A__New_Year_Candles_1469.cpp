#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int a, b, ans = 0, cnt = 0;
  cin >> a >> b;
  while (a > 0) {
    ans += a;
    a += cnt;
    cnt = a % b;
    a /= b;
  }
  cout << ans << endl;
  return 0;
}
