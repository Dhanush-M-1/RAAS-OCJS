#include <bits/stdc++.h>
using namespace std;
pair<long long, long long> st[800005];
void update(long long node, long long beg, long long end, long long pos,
            long long dist) {
  if (beg == end) {
    st[node].first += 1;
    st[node].second += dist;
    return;
  }
  long long mid = beg + (end - beg) / 2;
  if (pos <= mid)
    update(2 * node + 1, beg, mid, pos, dist);
  else
    update(2 * node + 2, mid + 1, end, pos, dist);
  st[node] = {st[2 * node + 1].first + st[2 * node + 2].first,
              st[2 * node + 1].second + st[2 * node + 2].second};
}
pair<long long, long long> query(long long node, long long beg, long long end,
                                 long long ql, long long qr) {
  if (beg > end || beg > qr || end < ql) return {0, 0};
  if (beg >= ql && end <= qr) return st[node];
  long long mid = beg + (end - beg) / 2;
  pair<long long, long long> a = query(2 * node + 1, beg, mid, ql, qr);
  pair<long long, long long> b = query(2 * node + 2, mid + 1, end, ql, qr);
  return {a.first + b.first, a.second + b.second};
}
int main() {
  long long n;
  cin >> n;
  vector<pair<long long, long long> > v(n);
  vector<long long> vel(n);
  for (long long i = 0; i < n; i++) cin >> v[i].first;
  map<long long, long long> velocity_idx;
  for (long long i = 0; i < n; i++) {
    cin >> v[i].second;
    velocity_idx[v[i].second] = 1;
  }
  sort(v.begin(), v.end());
  long long cnt = 0;
  for (auto it : velocity_idx) velocity_idx[it.first] = cnt++;
  memset(st, 0, sizeof(st));
  long long sz = (long long)velocity_idx.size() - 1;
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    pair<long long, long long> p =
        query(0, 0, sz, 0, velocity_idx[v[i].second]);
    ans += (v[i].first * p.first - p.second);
    update(0, 0, sz, velocity_idx[v[i].second], v[i].first);
  }
  cout << ans;
  return 0;
}
