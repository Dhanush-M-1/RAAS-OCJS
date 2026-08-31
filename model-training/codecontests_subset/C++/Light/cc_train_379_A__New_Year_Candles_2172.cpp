#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b;
  cin >> a >> b;
  int ans = a;
  while (a >= b) {
    int t = a / b;
    ans += t;
    a = t + (a - b * t);
  }
  cout << ans << "\n";
  return 0;
}
