#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios ::sync_with_stdio(false);
  cin.tie(0);
  long long n;
  cin >> n;
  long long arr[n];
  map<long long, long long> mp;
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
  }
  vector<long long> vrr(arr, arr + n);
  sort(vrr.rbegin(), vrr.rend());
  long long Q;
  cin >> Q;
  while (Q--) {
    long long k, pos;
    cin >> k >> pos;
    long long d = 0;
    mp = {};
    for (long long i = 0; i < k; i++) {
      mp[vrr[i]] += 1;
      d = vrr[i];
    }
    vector<long long> ans;
    for (long long i = 0; i < n; i++) {
      if (arr[i] == d && mp[d] > 0) {
        ans.push_back(arr[i]);
        mp[d] = mp[d] - 1;
      }
      if (arr[i] > d) {
        ans.push_back(arr[i]);
      }
    }
    pos = pos - 1;
    cout << ans[pos] << "\n";
  }
  return 0;
}
