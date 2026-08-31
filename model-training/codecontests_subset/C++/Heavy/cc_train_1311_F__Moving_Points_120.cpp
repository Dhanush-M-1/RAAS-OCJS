#include <bits/stdc++.h>
using namespace std;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
long long gcd(long long a, long long b) {
  for (; b; a %= b, swap(a, b))
    ;
  return a;
}
const int N = 200002;
pair<long long, long long> segTree[N * 4];
vector<long long> vIdx;
void update(int ptr, int s, int e, int i, pair<long long, long long> val) {
  if (i < s || e < i) return;
  if (s == e) {
    segTree[ptr].first += val.first;
    segTree[ptr].second += val.second;
    return;
  }
  update(ptr * 2, s, (s + e) / 2, i, val);
  update(ptr * 2 + 1, (s + e) / 2 + 1, e, i, val);
  segTree[ptr].first = segTree[ptr * 2].first + segTree[ptr * 2 + 1].first;
  segTree[ptr].second = segTree[ptr * 2].second + segTree[ptr * 2 + 1].second;
}
pair<long long, long long> getVal(int ptr, int s, int e, int l, int r) {
  if (r < s || e < l) return {0, 0};
  if (l <= s && e <= r) return segTree[ptr];
  pair<long long, long long> r1 = getVal(ptr * 2, s, (s + e) / 2, l, r);
  pair<long long, long long> r2 = getVal(ptr * 2 + 1, (s + e) / 2 + 1, e, l, r);
  return {r1.first + r2.first, r1.second + r2.second};
}
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  vector<pair<long long, long long> > a(n);
  for (int i = 0; i < n; i++) cin >> a[i].first;
  for (int i = 0; i < n; i++) {
    cin >> a[i].second;
    vIdx.push_back(a[i].second);
  }
  sort(a.begin(), a.end());
  sort(vIdx.begin(), vIdx.end());
  vIdx.erase(unique(vIdx.begin(), vIdx.end()), vIdx.end());
  for (int i = 0; i < n; i++) {
    int idx = lower_bound(vIdx.begin(), vIdx.end(), a[i].second) - vIdx.begin();
    a[i].second = idx;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    pair<long long, long long> res =
        getVal(1, 0, vIdx.size() - 1, 0, a[i].second);
    long long cnt = res.first, x_total = res.second;
    ans += a[i].first * cnt - x_total;
    update(1, 0, vIdx.size() - 1, a[i].second, {1, a[i].first});
  }
  cout << ans;
}
