#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10, Max = 101;
const int MOD = 1000000007;
const long long OO = 2e12 + 5000;
const long long Sqrt = 710;
const double PI = acos(-1);
const double EPS = 1e-9;
int n;
long long a[N];
pair<long long, long long> seg[4 * N];
long long lazy[8 * N];
void push(int p) {
  if (!lazy[p]) return;
  seg[p].first += lazy[p];
  lazy[p * 2] += lazy[p];
  lazy[p * 2 + 1] += lazy[p];
  lazy[p] = 0;
}
void build(int p = 1, int s = 1, int e = n) {
  if (s == e) {
    seg[p] = {a[s], -s};
    return;
  }
  int mid = (s + e) / 2;
  build(p * 2, s, mid);
  build(p * 2 + 1, mid + 1, e);
  seg[p] = min(seg[p * 2], seg[p * 2 + 1]);
}
void update(int from, int to, long long val, int p = 1, int s = 1, int e = n) {
  push(p);
  if (s > to || from > e) return;
  if (s >= from && e <= to) {
    lazy[p] += val;
    push(p);
    return;
  }
  int mid = (s + e) / 2;
  update(from, to, val, p * 2, s, mid);
  update(from, to, val, p * 2 + 1, mid + 1, e);
  seg[p] = min(seg[p * 2], seg[p * 2 + 1]);
}
pair<long long, long long> get(int from = 1, int to = n, int p = 1, int s = 1,
                               int e = n) {
  push(p);
  if (s > to || from > e) return {OO, OO};
  if (s >= from && e <= to) {
    return seg[p];
  }
  int mid = (s + e) / 2;
  pair<long long, long long> first = get(from, to, p * 2, s, mid);
  pair<long long, long long> second = get(from, to, p * 2 + 1, mid + 1, e);
  return min(first, second);
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
  }
  vector<int> sol(N);
  build();
  int cnt = 0;
  for (int i = 1; i <= n; ++i) {
    pair<long long, long long> mn = get();
    int idx = mn.second * -1;
    assert(mn.second != OO);
    sol[idx] = i;
    long long val = OO;
    update(idx, idx, val);
    val = i;
    update(1 + idx, n, -val);
  }
  for (int i = 1; i <= n; ++i) cout << sol[i] << " ";
  cout << endl;
}
