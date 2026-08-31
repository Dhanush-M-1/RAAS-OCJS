#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long>> v;
long long arr[200005];
map<long long, long long> mp;
map<long long, long long> rmp;
pair<long long, long long> bit[200005];
set<long long> s;
void insert(long long ind) {
  for (long long i = ind; i < 200005; i += i & -i)
    bit[i].first += 1, bit[i].second += rmp[ind];
}
pair<long long, long long> query(long long ind) {
  pair<long long, long long> ret = {0, 0};
  if (ind == 0) return ret;
  for (long long i = ind; i > 0; i -= i & -i)
    ret.first += bit[i].first, ret.second += bit[i].second;
  return ret;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> arr[i], s.insert(arr[i]);
  long long c = 1;
  for (auto i : s) rmp[c] = i, mp[i] = c++;
  for (long long i = 0; i < n; i++) {
    long long ve;
    cin >> ve;
    v.push_back({ve, mp[arr[i]]});
  }
  sort(v.begin(), v.end(), greater<pair<long long, long long>>());
  long long ans = 0;
  c = 0;
  long long val = 0;
  for (auto i : v) {
    pair<long long, long long> q = query(i.second);
    long long num = c - q.first;
    long long sum = val - q.second;
    ans += (sum - num * rmp[i.second]);
    c++;
    val += rmp[i.second];
    insert(i.second);
  }
  cout << ans << "\n";
}
