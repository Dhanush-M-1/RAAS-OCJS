#include <bits/stdc++.h>
using namespace std;
int n;
long long bit[200005][2];
void update(int x, long long val) {
  for (int i = x; i <= n; i += (i & -i)) bit[i][0] += val;
  for (int i = x; i <= n; i += (i & -i)) bit[i][1] += 1;
}
pair<long long, long long> query(int x) {
  long long ret1 = 0;
  long long ret2 = 0;
  for (int i = x; i > 0; i -= (i & -i)) ret1 += bit[i][0];
  for (int i = x; i > 0; i -= (i & -i)) ret2 += bit[i][1];
  return {ret1, ret2};
}
int main() {
  cin >> n;
  vector<long long> vel, tmp;
  vector<pair<long long, int> > pos;
  map<long long, int> mp;
  for (int i = 0; i < n; i++) {
    long long x;
    cin >> x;
    pos.push_back({x, i});
  }
  sort(pos.begin(), pos.end());
  for (int i = 0; i < n; i++) {
    long long x;
    cin >> x;
    vel.push_back(x);
    tmp.push_back(x);
  }
  sort(tmp.begin(), tmp.end());
  for (int i = 0; i < n; i++) {
    mp[tmp[i]] = i + 1;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int posnow = pos[i].second;
    long long xnow = pos[i].first;
    int now = mp[vel[posnow]];
    pair<long long, long long> q = query(now);
    long long val = xnow * q.second - q.first;
    ans += val;
    update(now, xnow);
  }
  cout << ans << endl;
  return 0;
}
