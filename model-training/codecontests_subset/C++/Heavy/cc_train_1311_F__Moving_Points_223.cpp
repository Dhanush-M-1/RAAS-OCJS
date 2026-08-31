#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 10;
const long long maxX = 2e8 + 10;
long long n;
long long sz = 1;
pair<long long, long long> p[maxn];
long long segsum[25 * maxn];
long long segtedad[25 * maxn];
long long L[25 * maxn];
long long R[25 * maxn];
long long ans;
void in();
void solve();
void add(long long id, long long l, long long r, long long idx, long long v);
pair<long long, long long> get(long long id, long long l, long long r,
                               long long L, long long R);
void out();
int main() {
  in();
  solve();
  out();
}
void in() {
  ios::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> p[i].first;
  for (long long i = 0; i < n; i++) cin >> p[i].second;
  for (long long i = 0; i < n; i++) p[i].second += 1e8;
}
void solve() {
  sort(p, p + n);
  for (long long i = 0; i < n; i++) {
    pair<long long, long long> wow = get(0, 0, maxX, 0, p[i].second + 1);
    add(0, 0, maxX, p[i].second, p[i].first);
    ans += p[i].first * wow.second - wow.first;
  }
}
void add(long long id, long long l, long long r, long long idx, long long v) {
  if (r - l == 1) {
    segsum[id] += v;
    segtedad[id]++;
    return;
  }
  long long mid = (l + r) >> 1;
  if (L[id] == 0) {
    L[id] = sz++;
    R[id] = sz++;
  }
  if (idx < mid)
    add(L[id], l, mid, idx, v);
  else
    add(R[id], mid, r, idx, v);
  segtedad[id] = segtedad[L[id]] + segtedad[R[id]];
  segsum[id] = segsum[L[id]] + segsum[R[id]];
}
pair<long long, long long> get(long long id, long long l, long long r,
                               long long second, long long e) {
  if (r <= second || e <= l) return {0, 0};
  if (second <= l && r <= e) return {segsum[id], segtedad[id]};
  long long mid = (l + r) >> 1;
  if (L[id] == 0) {
    L[id] = sz++;
    R[id] = sz++;
  }
  auto a = get(L[id], l, mid, second, e);
  auto b = get(R[id], mid, r, second, e);
  a.first += b.first;
  a.second += b.second;
  return a;
}
void out() { cout << ans; }
