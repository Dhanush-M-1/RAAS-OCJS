#include <bits/stdc++.h>
using namespace std;
long long int n, bit1[200050], bit2[200050];
vector<pair<long long int, long long int> > arr(200050);
map<long long int, long long int> mp;
long long int get1(int idx) {
  long long int ans = 0;
  while (idx > 0) {
    ans += bit1[idx];
    idx -= (idx & -idx);
  }
  return ans;
}
long long int get2(int idx) {
  long long int ans = 0;
  while (idx > 0) {
    ans += bit2[idx];
    idx -= (idx & -idx);
  }
  return ans;
}
void update1(int idx, int inc) {
  while (idx <= n) {
    bit1[idx] += inc;
    idx += (idx & -idx);
  }
}
void update2(int idx, int inc) {
  while (idx <= n) {
    bit2[idx] += inc;
    idx += (idx & -idx);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  arr.resize(n);
  for (int i = 0; i < n; i++) cin >> arr[i].first;
  for (int i = 0; i < n; i++) cin >> arr[i].second;
  sort(arr.begin(), arr.end());
  vector<long long int> v;
  for (auto a : arr) v.push_back(a.second);
  sort(v.begin(), v.end());
  int p = 1;
  for (auto x : v) mp[x] = p++;
  long long int ans = 0;
  for (int i = 0; i < n; i++) {
    long long int cnt = get1(mp[arr[i].second]);
    long long int sum = get2(mp[arr[i].second]);
    ans += cnt * arr[i].first - sum;
    update1(mp[arr[i].second], 1);
    update2(mp[arr[i].second], arr[i].first);
  }
  cout << ans;
  return 0;
}
