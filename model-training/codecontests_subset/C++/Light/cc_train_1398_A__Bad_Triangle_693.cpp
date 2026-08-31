#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n;
  cin >> n;
  long long int a[n];
  long long int i;
  for (long long int i = 0; i < n; i += 1) cin >> a[i];
  if ((a[0] + a[1]) > a[n - 1])
    cout << -1 << '\n';
  else
    cout << 1 << " " << 2 << " " << n << '\n';
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
