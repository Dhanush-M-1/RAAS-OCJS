#include <bits/stdc++.h>
using namespace std;
long long max(long long a, long long b) {
  if (a > b)
    return a;
  else
    return b;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    vector<long long> v(n);
    for (long long i = 0; i < n; i++) cin >> v[i];
    sort(v.begin(), v.end());
    if (n < 3) {
      cout << -1 << "\n";
      continue;
    }
    long long mn1 = v[0];
    long long mn2 = v[1];
    long long mx = v[n - 1];
    if (mn1 + mn2 > mx)
      cout << -1 << "\n";
    else
      cout << 1 << " " << 2 << " " << n << "\n";
  }
  return 0;
}
