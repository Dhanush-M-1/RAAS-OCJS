#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, k;
  cin >> n >> k;
  vector<long long> first, second, z;
  while (n--) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a)
      if (b)
        first.push_back(t);
      else
        second.push_back(t);
    else if (b)
      z.push_back(t);
  }
  sort(second.begin(), second.end());
  sort(z.begin(), z.end());
  for (long long i = 0; i < min(second.size(), z.size()); i++)
    first.push_back(second[i] + z[i]);
  sort(first.begin(), first.end());
  if (first.size() >= k)
    cout << accumulate(first.begin(), first.begin() + k, 0ll) << "\n";
  else
    cout << -1 << "\n";
}
