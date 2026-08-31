#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
long long a[N];
pair<long long, long long> seg[4 * N];
void build(long long ind, long long l, long long r) {
  if (l > r) return;
  if (l == r) {
    seg[ind] = {a[l], l};
    return;
  }
  long long mid = (l + r) / 2;
  build(2 * ind + 1, l, mid);
  build(2 * ind + 2, mid + 1, r);
  if (seg[2 * ind + 1].first < seg[2 * ind + 2].first)
    seg[ind] = seg[2 * ind + 1];
  else
    seg[ind] = seg[2 * ind + 2];
}
long long lazy[4 * N];
void update(long long ind, long long l, long long r, long long lq, long long rq,
            long long val) {
  if (lazy[ind] != 0) {
    seg[ind].first += lazy[ind];
    if (l != r) {
      lazy[ind * 2 + 1] += lazy[ind];
      lazy[ind * 2 + 2] += lazy[ind];
    }
    lazy[ind] = 0;
  }
  if (l > r || r < lq || rq < l) return;
  if (l >= lq && r <= rq) {
    seg[ind].first += val;
    if (l != r) {
      lazy[ind * 2 + 1] += val;
      lazy[ind * 2 + 2] += val;
    }
    return;
  }
  long long mid = (l + r) / 2;
  update(2 * ind + 1, l, mid, lq, rq, val);
  update(2 * ind + 2, mid + 1, r, lq, rq, val);
  if (seg[2 * ind + 1].first < seg[2 * ind + 2].first)
    seg[ind] = seg[2 * ind + 1];
  else
    seg[ind] = seg[2 * ind + 2];
}
pair<long long, long long> query(long long ind, long long l, long long r,
                                 long long lq, long long rq) {
  if (l > r || r < lq || rq < l) return {1000000007, 0};
  if (lazy[ind] != 0) {
    seg[ind].first += lazy[ind];
    if (l != r) {
      lazy[ind * 2 + 1] += lazy[ind];
      lazy[ind * 2 + 2] += lazy[ind];
    }
    lazy[ind] = 0;
  }
  if (l >= lq && r <= rq) return seg[ind];
  long long mid = (l + r) / 2;
  pair<long long, long long> k1, k2;
  k1 = query(2 * ind + 1, l, mid, lq, rq);
  k2 = query(2 * ind + 2, mid + 1, r, lq, rq);
  if (k1.first < k2.first)
    return k1;
  else
    return k2;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  long long n, i, k;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  build(0, 0, n - 1);
  long long ans[n];
  pair<long long, long long> x;
  long long l;
  k = 1;
  for (i = 0; i < n; i++) {
    x = query(0, 0, n - 1, 0, n - 1);
    l = x.second;
    ans[l] = k;
    update(0, 0, n - 1, l, l, 1000000007000000);
    update(0, 0, n - 1, l + 1, n - 1, -k);
    k++;
  }
  for (i = 0; i < n; i++) cout << ans[i] << " ";
  return 0;
}
