#include <bits/stdc++.h>
using namespace std;
long long int n, i, x[100005], h[100005], ans;
int main() {
  cin >> n;
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  if (n == 1) {
    cout << "1" << endl;
    return 0;
  }
  ans = 2;
  for (i = 1; i < n - 1; i++) {
    if ((x[i] - h[i]) > x[i - 1])
      ans++;
    else if ((x[i] + h[i]) < x[i + 1]) {
      ans++;
      x[i] = x[i] + h[i];
    }
  }
  cout << ans << endl;
  return 0;
}
