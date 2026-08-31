#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, b, ans;
  cin >> n >> b;
  ans = n;
  while (n / b != 0) {
    ans += n / b;
    n = n / b + n % b;
  }
  cout << ans;
  return 0;
}
