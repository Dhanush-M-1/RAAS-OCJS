#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, num, ans = 2005;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    cin >> num;
    if (!(m % num)) ans = min(ans, m / num);
  }
  cout << ans << '\n';
}
