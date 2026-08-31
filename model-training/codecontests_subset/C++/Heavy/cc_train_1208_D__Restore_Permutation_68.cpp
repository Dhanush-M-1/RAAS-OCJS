#include <bits/stdc++.h>
using namespace std;
const long long Nmax = 2e6 + 5;
long long v[Nmax];
long long ans[Nmax];
long long lazy[4 * Nmax];
pair<long long, long long> all[4 * Nmax];
long long p, q, val;
void add(long long &first, long long val) {
  if (first != LLONG_MAX) first += val;
}
void propagate(long long node) {
  if (lazy[node]) {
    add(lazy[(node << 1)], lazy[node]);
    add(lazy[((node << 1) + 1)], lazy[node]);
    add(all[(node << 1)].first, lazy[node]);
    add(all[((node << 1) + 1)].first, lazy[node]);
    lazy[node] = 0;
  }
}
void build(long long lo, long long hi, long long node) {
  if (lo == hi) {
    all[node] = make_pair(v[lo], -lo);
  } else {
    long long mid = (lo + hi) >> 1;
    build(lo, mid, (node << 1));
    build(mid + 1, hi, ((node << 1) + 1));
    all[node] = min(all[(node << 1)], all[((node << 1) + 1)]);
  }
}
void update(long long lo, long long hi, long long node) {
  propagate(node);
  if (p <= lo and hi <= q) {
    lazy[node] += val;
    all[node].first += val;
  } else {
    long long mid = (lo + hi) >> 1;
    if (p <= mid) update(lo, mid, (node << 1));
    if (mid < q) update(mid + 1, hi, ((node << 1) + 1));
    all[node] = min(all[(node << 1)], all[((node << 1) + 1)]);
  }
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(nullptr);
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; ++i) {
    cin >> v[i];
  }
  build(1, n, 1);
  for (long long pos, i = 1; i <= n; ++i) {
    pos = -all[1].second;
    ans[pos] = i;
    p = q = pos;
    val = LLONG_MAX;
    update(1, n, 1);
    p = pos + 1;
    q = n;
    val = -i;
    if (p <= q) update(1, n, 1);
  }
  for (long long i = 1; i <= n; ++i) cout << ans[i] << ' ';
  return 0;
}
