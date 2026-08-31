#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, k, ans = 0;
  cin >> n >> k;
  long long int a[n];
  for (long long int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  for (long long int i = 0; i < n; i++) {
    if (k % a[i] == 0) ans = a[i];
  }
  ans = k / ans;
  cout << ans;
  return 0;
}
