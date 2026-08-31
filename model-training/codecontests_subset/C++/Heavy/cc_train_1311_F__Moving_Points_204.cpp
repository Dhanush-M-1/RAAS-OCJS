#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
struct {
  int l, r;
  long long sum;
  long long cnt;
} A[N * 4];
pair<pair<long long, long long>, int> pt[N];
int n;
bool cmp(pair<pair<long long, long long>, int> x1,
         pair<pair<long long, long long>, int> x2) {
  return x1.first.first < x2.first.first;
}
bool cmp1(pair<pair<long long, long long>, int> x1,
          pair<pair<long long, long long>, int> x2) {
  if (x1.first.second == x2.first.second) {
    return x1.first.first > x2.first.first;
  }
  return x1.first.second > x2.first.second;
}
void build(int rt, int l, int r) {
  A[rt].l = l;
  A[rt].r = r;
  if (l != r) {
    build(rt * 2, l, (l + r) / 2);
    build(rt * 2 + 1, (l + r) / 2 + 1, r);
  }
}
void update(int rt, int index, long long v) {
  if (A[rt].l > index || A[rt].r < index) {
    return;
  }
  if (A[rt].l == A[rt].r) {
    A[rt].sum = v;
    if (v == 0) {
      A[rt].cnt = 0;
    } else
      A[rt].cnt = 1;
    return;
  } else {
    update(rt * 2, index, v);
    update(rt * 2 + 1, index, v);
    A[rt].sum = A[rt * 2].sum + A[rt * 2 + 1].sum;
    A[rt].cnt = A[rt * 2].cnt + A[rt * 2 + 1].cnt;
  }
}
long long query(int rt, int l, int r) {
  if (A[rt].l > r || A[rt].r < l) {
    return 0;
  }
  if (A[rt].l >= l && A[rt].r <= r) {
    return A[rt].sum;
  }
  return query(rt * 2, l, r) + query(rt * 2 + 1, l, r);
}
long long query2(int rt, int l, int r) {
  if (A[rt].l > r || A[rt].r < l) {
    return 0;
  }
  if (A[rt].l >= l && A[rt].r <= r) {
    return A[rt].cnt;
  }
  return query2(rt * 2, l, r) + query2(rt * 2 + 1, l, r);
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> pt[i].first.first;
  }
  for (int i = 1; i <= n; i++) {
    cin >> pt[i].first.second;
  }
  sort(pt + 1, pt + 1 + n, cmp);
  build(1, 1, n);
  for (int i = 1; i <= n; i++) {
    pt[i].second = i;
    update(1, i, pt[i].first.first);
  }
  sort(pt + 1, pt + 1 + n, cmp1);
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    ans += query2(1, 1, pt[i].second - 1) * pt[i].first.first -
           query(1, 1, pt[i].second - 1);
    update(1, pt[i].second, 0);
  }
  cout << ans;
  return 0;
}
