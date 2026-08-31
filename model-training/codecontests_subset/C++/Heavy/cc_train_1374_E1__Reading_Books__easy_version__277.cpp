#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007;
long long dx[] = {1, -1, 0, 0};
long long dy[] = {0, 0, 1, -1};
void solve() {
  long long n, k;
  cin >> n >> k;
  vector<long long> arr1, arr2, v;
  for (long long i = 0; i < n; i++) {
    long long x, a, b;
    cin >> x >> a >> b;
    if (a && b)
      v.push_back(x);
    else if (a)
      arr1.push_back(x);
    else if (b)
      arr2.push_back(x);
  }
  sort((arr1).begin(), (arr1).end());
  sort((arr2).begin(), (arr2).end());
  for (long long i = 0; i < min(arr1.size(), arr2.size()); i++)
    v.push_back(arr1[i] + arr2[i]);
  sort((v).begin(), (v).end());
  if (v.size() < k)
    cout << -1 << '\n';
  else {
    long long ans = 0;
    for (long long i = 0; i < k; i++) ans += v[i];
    cout << ans << '\n';
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long test;
  test = 1;
  long long x = 1;
  while (test--) {
    solve();
  }
  return 0;
}
