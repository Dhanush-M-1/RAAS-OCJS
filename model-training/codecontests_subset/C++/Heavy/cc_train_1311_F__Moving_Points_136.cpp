#include <bits/stdc++.h>
using namespace std;
int dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[8] = {1, -1, -1, 0, 1, -1, 0, 1};
long long bit[1000005], bit1[1000005];
long long sum(long long x) {
  long long s = 0;
  while (x > 0) {
    s += bit[x];
    x -= (x & (-x));
  }
  return s;
}
void update(long long x, long long val) {
  while (x < 1000005) {
    bit[x] += val;
    x += (x & (-x));
  }
}
long long cnt(long long x) {
  long long s = 0;
  while (x > 0) {
    s += bit1[x];
    x -= (x & (-x));
  }
  return s;
}
void updatecnt(long long x) {
  while (x < 1000005) {
    bit1[x] += 1;
    x += (x & (-x));
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  long long pos[n + 1], vel[n + 1];
  vector<long long> v;
  map<long long, long long> h, h1;
  for (long long i = 1; i < n + 1; i++) cin >> pos[i];
  for (long long i = 1; i < n + 1; i++) {
    cin >> vel[i];
    if (!h[vel[i]]) v.push_back(vel[i]);
    h[vel[i]] = 1;
  }
  v.push_back(-1000000000);
  sort(v.begin(), v.end());
  for (long long i = 1; i < v.size(); i++) {
    if (!h1[v[i]]) h1[v[i]] = i;
  }
  vector<pair<long long, long long> > v1;
  for (long long i = 1; i < n + 1; i++) {
    vel[i] = h1[vel[i]];
    v1.push_back({pos[i], vel[i]});
  }
  sort(v1.begin(), v1.end());
  long long ans = 0;
  for (long long i = 0; i < v1.size(); i++) {
    long long s = sum(v1[i].second);
    long long c = cnt(v1[i].second);
    ans += c * v1[i].first - s;
    update(v1[i].second, v1[i].first);
    updatecnt(v1[i].second);
  }
  cout << ans;
  return 0;
}
