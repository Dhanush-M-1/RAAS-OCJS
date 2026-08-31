#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, j, k;
  cin >> n;
  long long int x, ans = LLONG_MIN;
  for (i = 0; i < n; i++) {
    cin >> x;
    ans = max(ans, min(abs(x - 1), abs(1000000 - x)));
  }
  cout << ans << '\n';
}
