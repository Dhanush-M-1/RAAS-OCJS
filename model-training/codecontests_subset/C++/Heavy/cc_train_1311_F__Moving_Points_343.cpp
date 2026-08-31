#include <bits/stdc++.h>
using namespace std;
const int N = 1000007, inf = 0x3f3f3f3f;
int x[N], v[N];
pair<long long, int> seg[N + N];
pair<long long, int> soma(pair<long long, int> x, pair<long long, int> y) {
  return pair<long long, int>(x.first + y.first, x.second + y.second);
}
pair<long long, int> query(int l, int r) {
  pair<long long, int> tot = pair<long long, int>(0ll, 0);
  for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
    if (l & 1) tot = soma(tot, seg[l++]);
    if (r & 1) tot = soma(tot, seg[--r]);
  }
  return tot;
}
void update(int p, int val) {
  p += N;
  for (seg[p] = pair<long long, int>(seg[p].first + val, seg[p].second + 1);
       p > 1; p >>= 1) {
    seg[p >> 1] = soma(seg[p], seg[p ^ 1]);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> x[i];
  }
  vector<int> vec;
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
    vec.push_back(v[i]);
  }
  sort(vec.begin(), vec.end());
  vec.erase(unique(vec.begin(), vec.end()), vec.end());
  vector<int> id(n);
  iota(id.begin(), id.end(), 0);
  sort(id.begin(), id.end(), [](int i, int j) { return x[i] < x[j]; });
  long long ans = 0;
  for (int i : id) {
    int j = lower_bound(vec.begin(), vec.end(), v[i]) - vec.begin();
    long long sx;
    int cnt;
    tie(sx, cnt) = query(0, j + 1);
    ans += (long long)x[i] * cnt - sx;
    update(j, x[i]);
  }
  memset(seg, 0, sizeof seg);
  reverse(id.begin(), id.end());
  for (int i : id) {
    int j = lower_bound(vec.begin(), vec.end(), v[i]) - vec.begin();
    long long sx;
    int cnt;
    tie(sx, cnt) = query(j, vec.size());
    ans += sx - (long long)x[i] * cnt;
    update(j, x[i]);
  }
  cout << ans / 2 << endl;
}
