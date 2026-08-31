#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int ans;
  ans = n;
  while (n >= m) {
    ans += n / m;
    n = n % m + n / m;
  }
  cout << ans << endl;
  return 0;
}
