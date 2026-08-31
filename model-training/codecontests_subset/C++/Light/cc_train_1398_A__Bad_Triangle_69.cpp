#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, i;
  cin >> n;
  vector<long long> v(n);
  for (i = 0; i < n; i++) cin >> v[i];
  if (v[0] + v[1] <= v[n - 1])
    cout << '1' << " " << '2' << " " << n << "\n";
  else
    cout << "-1"
         << "\n";
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
