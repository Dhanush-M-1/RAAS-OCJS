#include <bits/stdc++.h>
using namespace std;
int n, ans[200100];
long long s[200100];
pair<long long, int> seg[800100];
long long lazy[800100];
void build(int l, int r, int ind) {
  if (l == r) {
    seg[ind] = {s[l], l};
    return;
  }
  int mid = (l + r) / 2;
  build(l, mid, ind * 2);
  build(mid + 1, r, ind * 2 + 1);
  if (seg[ind * 2].first < seg[ind * 2 + 1].first)
    seg[ind] = seg[ind * 2];
  else if (seg[ind * 2].first > seg[ind * 2 + 1].first)
    seg[ind] = seg[ind * 2 + 1];
  else {
    if (seg[ind * 2].second > seg[ind * 2 + 1].second)
      seg[ind] = seg[ind * 2];
    else
      seg[ind] = seg[ind * 2 + 1];
  }
}
void push(int ind) {
  lazy[ind * 2] += lazy[ind];
  lazy[ind * 2 + 1] += lazy[ind];
  lazy[ind] = 0;
}
void update(int l, int r, int x, int y, int ind, long long add) {
  if (x > y or l > y or r < x) return;
  if (l >= x and r <= y) {
    lazy[ind] += add;
    seg[ind].first += lazy[ind];
    if (l != r) {
      lazy[ind * 2] += lazy[ind];
      lazy[ind * 2 + 1] += lazy[ind];
    }
    lazy[ind] = 0;
    return;
  }
  seg[ind].first += lazy[ind];
  push(ind);
  int mid = (l + r) / 2;
  update(l, mid, x, y, ind * 2, add);
  update(mid + 1, r, x, y, ind * 2 + 1, add);
  if (seg[ind * 2].first + lazy[ind * 2] <
      seg[ind * 2 + 1].first + lazy[ind * 2 + 1])
    seg[ind] = {seg[ind * 2].first + lazy[ind * 2], seg[ind * 2].second};
  else if (seg[ind * 2].first + lazy[ind * 2] >
           seg[ind * 2 + 1].first + lazy[ind * 2 + 1])
    seg[ind] = {seg[ind * 2 + 1].first + lazy[ind * 2 + 1],
                seg[ind * 2 + 1].second};
  else {
    if (seg[ind * 2].second > seg[ind * 2 + 1].second)
      seg[ind] = {seg[ind * 2].first + lazy[ind * 2], seg[ind * 2].second};
    else
      seg[ind] = {seg[ind * 2 + 1].first + lazy[ind * 2 + 1],
                  seg[ind * 2 + 1].second};
  }
}
pair<long long, int> calc(int l, int r, int ind) {
  seg[ind].first += lazy[ind];
  if (l == r) {
    lazy[ind] = 0;
    return seg[ind];
  } else
    push(ind);
  if (seg[ind].first > 0) return seg[ind];
  int mid = (l + r) / 2;
  pair<long long, int> b = calc(mid + 1, r, ind * 2 + 1);
  if (b.first <= 0)
    return b;
  else
    return calc(l, mid, ind * 2);
}
int main() {
  memset(lazy, 0, sizeof(lazy));
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> s[i];
  build(1, n, 1);
  for (int i = 1; i <= n; i++) {
    pair<long long, int> a = calc(1, n, 1);
    ans[a.second] = i;
    update(1, n, a.second + 1, n, 1, -i);
    update(1, n, a.second, a.second, 1, 1e12);
  }
  for (int i = 1; i <= n; i++) {
    cout << ans[i] << " ";
  }
  return 0;
}
