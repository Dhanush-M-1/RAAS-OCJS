#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, c, ar[1005] = {0};
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> ar[i];
  long x, ans = 0, ll;
  for (int i = 0; i < n - 1; i++) {
    x = (ar[i] - ar[i + 1] - c);
    ans = max(ans, x);
  }
  cout << ans << endl;
  return 0;
}
