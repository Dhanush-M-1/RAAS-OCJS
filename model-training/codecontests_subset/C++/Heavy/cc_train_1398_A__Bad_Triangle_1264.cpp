#include <bits/stdc++.h>
using namespace std;
bool isPowerOfTwo(long long int x) { return x && (!(x & (x - 1))); }
void solve() {
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int>> vp;
  for (long long int i = 0; i < n; ++i) {
    long long int x;
    cin >> x;
    vp.push_back({x, i + 1});
  }
  sort(vp.begin(), vp.end());
  if ((vp[0].first + vp[1].first) <= vp[n - 1].first) {
    long long int arr[3] = {vp[0].second, vp[1].second, vp[n - 1].second};
    sort(arr, arr + 3);
    for (long long int i = 0; i <= 2; ++i) cout << arr[i] << " ";
  } else
    cout << "-1";
  cout << "\n";
}
int32_t main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T = 1;
  cin >> T;
  while (T--) solve();
  return 0;
}
