#include <bits/stdc++.h>
using namespace std;
const long double PI = acosl(-1.0);
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, x, mx = -1, sum = 0;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> x;
    sum += x;
    mx = max(x, mx);
  }
  long long ans = ceil(2.0 * sum / n);
  if (ans < mx) ans = mx;
  if (ans * n == 2 * sum) ans++;
  cout << ans;
  return 0;
}
