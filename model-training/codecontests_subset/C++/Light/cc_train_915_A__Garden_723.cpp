#include <bits/stdc++.h>
using namespace std;
void sol() {
  long long int n, k;
  cin >> n >> k;
  long long int a[n + 1];
  for (int i = 0; i < n; ++i) cin >> a[i];
  sort(a, a + n);
  long long int ans = INT_MAX;
  for (int i = 0; i < n; ++i) {
    if (k % a[i] == 0) ans = min(ans, k / a[i]);
  }
  cout << ans << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  sol();
  return 0;
}
