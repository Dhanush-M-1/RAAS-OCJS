#include <bits/stdc++.h>
using namespace std;
set<pair<int, int> > t;
int a[200105];
vector<pair<int, int> > vec[200105];
int ans[200105];
int seg[200105 << 2];
void build(int t, int i, int j) {
  if (i == j) {
    seg[t] = 1;
    return;
  }
  int left = t << 1, right = left | 1, mid = (i + j) >> 1;
  build(left, i, mid);
  build(right, mid + 1, j);
  seg[t] = seg[left] + seg[right];
}
int upd_ind;
int val;
void update(int t, int i, int j) {
  if (i == j) {
    seg[t] += val;
    return;
  }
  int left = t << 1, right = left | 1, mid = (i + j) >> 1;
  if (upd_ind <= mid)
    update(left, i, mid);
  else
    update(right, mid + 1, j);
  seg[t] = seg[left] + seg[right];
}
int query(int t, int i, int j, int p) {
  if (i == j) {
    return a[i];
  }
  int left = t << 1, right = left | 1, mid = (i + j) >> 1;
  if (seg[left] >= p)
    return query(left, i, mid, p);
  else
    return query(right, mid + 1, j, p - seg[left]);
}
int compute(int p, int n) { return query(1, 1, n, p); }
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    t.insert(make_pair(a[i], -i));
  }
  int m;
  scanf("%d", &m);
  for (int i = 1; i <= m; i++) {
    int k, p;
    scanf("%d", &k);
    scanf("%d", &p);
    vec[k].push_back(make_pair(p, i));
  }
  build(1, 1, n);
  for (int k = n; k > 0; k--) {
    pair<int, int> elem = *t.begin();
    int ind = -elem.second;
    for (int j = 0; j < vec[k].size(); j++) {
      int p = vec[k][j].first;
      int ans_index = vec[k][j].second;
      ans[ans_index] = compute(p, n);
    }
    upd_ind = ind;
    val = -1;
    update(1, 1, n);
    t.erase(elem);
  }
  for (int i = 1; i <= m; i++) {
    printf("%d\n", ans[i]);
  }
}
