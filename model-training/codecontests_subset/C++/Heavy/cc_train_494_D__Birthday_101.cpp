#include <bits/stdc++.h>
using namespace std;
int n;
int q;
struct st {
  long long int lazy;
  long long int sum1;
  long long int sum2;
  long long int cnt;
  st() { cnt = lazy = sum1 = sum2 = 0; }
};
vector<pair<int, long long int> > v[100002];
long long int dist[100002];
bool use[100002];
int siz;
int star[100002];
int en[100002];
int ar[100002];
inline void dfs(int b, long long int D = 0) {
  if (D >= 1000000007LL) {
    D %= 1000000007LL;
  }
  dist[b] = D;
  use[b] = true;
  star[b] = siz;
  ar[siz] = b;
  siz++;
  for (int i = 0; i < v[b].size(); i++) {
    if (use[v[b][i].first] == false) {
      dfs(v[b][i].first, D + v[b][i].second);
    }
  }
  en[b] = siz;
}
st seg[100002 * 4];
st merge(st a, st b) {
  st r;
  r.sum1 = a.sum1 + b.sum1;
  r.sum2 = a.sum2 + b.sum2;
  r.cnt = a.cnt + b.cnt;
  r.sum1 %= 1000000007LL;
  r.sum2 %= 1000000007LL;
  return r;
}
void update(int b) {
  if (seg[b].lazy != 0) {
    if (seg[b].lazy >= 1000000007LL) {
      seg[b].lazy %= 1000000007LL;
    }
    if (b * 2 + 2 < 100002 * 4) {
      seg[b * 2 + 1].lazy += seg[b].lazy;
      if (seg[b * 2 + 1].lazy >= 1000000007LL) {
        seg[b * 2 + 1].lazy %= 1000000007LL;
      }
      seg[b * 2 + 2].lazy += seg[b].lazy;
      if (seg[b * 2 + 2].lazy >= 1000000007LL) {
        seg[b * 2 + 2].lazy %= 1000000007LL;
      }
    }
    seg[b].sum2 += (((seg[b].lazy * seg[b].lazy) % 1000000007LL) * seg[b].cnt);
    if (seg[b].sum2 >= 1000000007LL) {
      seg[b].sum2 %= 1000000007LL;
    }
    seg[b].sum2 += 2LL * seg[b].lazy * seg[b].sum1;
    if (seg[b].sum2 >= 1000000007LL) {
      seg[b].sum2 %= 1000000007LL;
    }
    seg[b].sum1 += seg[b].cnt * seg[b].lazy;
    seg[b].sum1 %= 1000000007LL;
    seg[b].lazy = 0;
  }
}
inline void init(int b, int l, int r) {
  seg[b].cnt = r - l;
  if (l + 1 == r) {
    seg[b].sum2 = dist[ar[l]] * dist[ar[l]];
    if (seg[b].sum2 >= 1000000007LL) {
      seg[b].sum2 %= 1000000007LL;
    }
    seg[b].sum1 = dist[ar[l]];
    if (seg[b].sum1 >= 1000000007LL) {
      seg[b].sum1 %= 1000000007LL;
    }
    return;
  }
  init(b * 2 + 1, l, (l + r) >> 1);
  init(b * 2 + 2, (l + r) >> 1, r);
  seg[b] = merge(seg[b * 2 + 1], seg[b * 2 + 2]);
}
long long int ans[100002];
vector<pair<int, int> > vv[100002];
inline void add(int b, int l, int r, int ll, int rr, long long int x) {
  if (x >= 1000000007LL) {
    x %= 1000000007LL;
  }
  update(b);
  if (r <= ll || rr <= l) {
    return;
  }
  if (ll <= l && r <= rr) {
    seg[b].lazy += (long long int)(x);
    update(b);
    return;
  }
  add(b * 2 + 1, l, (l + r) >> 1, ll, rr, x);
  add(b * 2 + 2, (l + r) >> 1, r, ll, rr, x);
  seg[b] = merge(seg[b * 2 + 1], seg[b * 2 + 2]);
}
inline st query(int b, int l, int r, int ll, int rr) {
  update(b);
  if (ll <= l && r <= rr) {
    return seg[b];
  }
  if (rr <= l || r <= ll) {
    return st();
  }
  return merge(query(b * 2 + 1, l, (l + r) >> 1, ll, rr),
               query(b * 2 + 2, (l + r) >> 1, r, ll, rr));
}
inline void dfs2(int b) {
  use[b] = false;
  for (int i = 0; i < v[b].size(); i++) {
    if (use[v[b][i].first] == true) {
      add(0, 0, siz, 0, siz, v[b][i].second);
      add(0, 0, siz, star[v[b][i].first], en[v[b][i].first],
          (1000000007LL - v[b][i].second) * 2LL);
      dfs2(v[b][i].first);
      add(0, 0, siz, 0, siz, 1000000007LL - v[b][i].second);
      add(0, 0, siz, star[v[b][i].first], en[v[b][i].first],
          v[b][i].second * 2LL);
    }
  }
  long long int D = query(0, 0, siz, 0, siz).sum2;
  D %= 1000000007LL;
  D = 1000000007LL - D;
  D %= 1000000007LL;
  for (int i = 0; i < vv[b].size(); i++) {
    ans[vv[b][i].second] =
        2LL * query(0, 0, siz, star[vv[b][i].first], en[vv[b][i].first]).sum2 +
        D;
    ans[vv[b][i].second] %= 1000000007LL;
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    a--;
    b--;
    v[a].push_back(make_pair(b, c));
    v[b].push_back(make_pair(a, c));
  }
  cin >> q;
  dfs(0);
  init(0, 0, n);
  for (int i = 0; i < q; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--;
    b--;
    vv[a].push_back(make_pair(b, i));
  }
  dfs2(0);
  for (int i = 0; i < q; i++) {
    printf("%lld\n", ans[i]);
  }
  return 0;
}
