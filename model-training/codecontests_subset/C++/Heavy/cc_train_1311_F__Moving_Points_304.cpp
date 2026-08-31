#include <bits/stdc++.h>
using namespace std;
long long bit1[200005], bit2[200005];
inline void upd(long long idx, long long val, long long bit[]) {
  while (idx < 200005) {
    bit[idx] += val;
    idx += (idx & -idx);
  }
}
inline long long que(long long idx, long long bit[]) {
  long long ans = 0;
  while (idx > 0) {
    ans += bit[idx];
    idx -= (idx & -idx);
  }
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  vector<long long> v;
  map<long long, long long> m;
  pair<long long, long long> arr[n];
  for (long long i = 0; i < n; i++) cin >> arr[i].first;
  for (long long i = 0; i < n; i++) {
    cin >> arr[i].second;
    if (m[arr[i].second] == 0) {
      m[arr[i].second]++;
      v.push_back(arr[i].second);
    }
  }
  sort(v.begin(), v.end());
  sort(arr, arr + n);
  for (long long i = 0; i < n; i++) {
    long long x = lower_bound(v.begin(), v.end(), arr[i].second) - v.begin();
    arr[i].second = x + 1;
  }
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    long long x = que(arr[i].second, bit1), y = que(arr[i].second, bit2);
    ans += (x * arr[i].first - y);
    upd(arr[i].second, 1, bit1);
    upd(arr[i].second, arr[i].first, bit2);
  }
  cout << ans << '\n';
}
