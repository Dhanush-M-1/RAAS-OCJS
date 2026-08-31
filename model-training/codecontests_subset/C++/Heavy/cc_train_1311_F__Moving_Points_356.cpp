#include <bits/stdc++.h>
using namespace std;
const int N = 200000;
long long BIT1[200001];
long long cnt1[200001];
map<long long, long long> r, l;
pair<long long, long long> arr[200001];
int n;
void upd1(long long idx, long long val) {
  for (; idx <= N; idx = (idx | (idx + 1))) {
    BIT1[idx] += val;
    cnt1[idx]++;
  }
}
pair<long long, long long> query1(int idx) {
  if (idx < 0) return {0, 0};
  long long sum = 0;
  int ct = 0;
  for (; idx >= 0; idx = (idx & (idx + 1)) - 1) {
    sum += BIT1[idx];
    ct += cnt1[idx];
  }
  return {sum, ct};
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> arr[i].first;
  for (int i = 1; i <= n; i++) cin >> arr[i].second;
  sort(arr + 1, arr + n + 1);
  for (int i = 1; i <= n; i++) r[arr[i].second] = 0;
  long long ind = 1;
  for (auto &it : r) {
    it.second = ind;
    ind++;
  }
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    long long vel = r[arr[i].second];
    pair<long long, long long> p = query1(vel);
    ans += (p.second) * (arr[i].first);
    ans -= p.first;
    upd1(vel, arr[i].first);
  }
  cout << ans;
}
