#include <bits/stdc++.h>
using namespace std;
bool isv(char c) {
  if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
    return true;
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, x, ma = 1, mi = 1000000;
  cin >> n;
  for (long long int i = 0; i < n; i++) {
    cin >> x;
    if (x <= 500000)
      ma = max(ma, x);
    else
      mi = min(mi, x);
  }
  long long int ans = max(ma - 1, 1000000 - mi);
  cout << ans;
  return 0;
}
