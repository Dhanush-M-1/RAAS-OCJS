#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int a, b;
  cin >> a >> b;
  int ans = a;
  while (a >= b) {
    int k = a / b;
    ans += k;
    a = a % b + k;
  }
  cout << ans << '\n';
  return 0;
}
