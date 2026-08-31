#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, k;
  cin >> n >> k;
  vector<long long> arr1, arr2, arr3;
  for (long long i = 0; i < n; i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) arr1.push_back(t);
    if (a == 1 && b == 0) arr2.push_back(t);
    if (a == 0 && b == 1) arr3.push_back(t);
  }
  sort(arr2.begin(), arr2.end());
  sort(arr3.begin(), arr3.end());
  for (long long i = 0; i < min(arr2.size(), arr3.size()); i++) {
    arr1.push_back(arr2[i] + arr3[i]);
  }
  sort(arr1.begin(), arr1.end());
  if (k > arr1.size())
    cout << -1 << '\n';
  else {
    long long res = 0;
    for (long long i = 0; i < k; i++) {
      res += arr1[i];
    }
    cout << res << '\n';
  }
  return 0;
}
