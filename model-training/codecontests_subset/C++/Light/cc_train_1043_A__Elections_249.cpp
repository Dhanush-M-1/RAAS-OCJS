#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
void solve() {
  long long int n;
  cin >> n;
  long long int a[n], sum = 0;
  for (int(i) = (0); (i) < (n); ++(i)) {
    cin >> a[i];
    sum += a[i];
  }
  sort(a, a + n, greater<int>());
  long long int ans = a[0];
  while (1) {
    if ((ans * n) - sum > sum) {
      cout << ans << "\n";
      return;
    } else
      ans += 1;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solve();
  return 0;
}
