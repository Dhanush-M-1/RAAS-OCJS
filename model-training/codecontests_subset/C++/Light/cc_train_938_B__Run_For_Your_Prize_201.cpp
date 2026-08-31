#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long double PI = 3.141592653589793;
int main() {
  ios_base::sync_with_stdio(false);
  long long int n, ans = 0, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    ans = max(ans, min(a - 1, 1000000 - a));
  }
  cout << ans;
  return 0;
}
