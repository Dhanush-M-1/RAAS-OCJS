#include <bits/stdc++.h>
using namespace std;
pair<int, int> a[200005];
vector<int> g;
struct node {
  long long w, num;
} tree[1000005];
void update(int x, long long val, int l, int r, int k = 1) {
  if (l == r and l == x) {
    tree[k].w++;
    tree[k].num += val;
    return;
  }
  int mid = l + r >> 1;
  if (x <= mid)
    update(x, val, l, mid, k << 1);
  else
    update(x, val, mid + 1, r, k << 1 | 1);
  tree[k].w = tree[k << 1].w + tree[k << 1 | 1].w;
  tree[k].num = tree[k << 1].num + tree[k << 1 | 1].num;
}
long long cnt, sum;
void query(int x, int y, int l, int r, int k = 1) {
  if (x <= l and y >= r) {
    if (tree[k].w) sum += tree[k].num, cnt += tree[k].w;
    return;
  }
  int mid = l + r >> 1;
  if (x <= mid) query(x, y, l, mid, k << 1);
  if (y > mid) query(x, y, mid + 1, r, k << 1 | 1);
}
map<int, int> id;
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].first;
  }
  for (int i = 1; i <= n; ++i) {
    cin >> a[i].second;
    g.push_back(a[i].second);
  }
  sort(a + 1, a + 1 + n);
  sort(g.begin(), g.end());
  g.erase(unique(g.begin(), g.end()), g.end());
  for (int i = 0; i < g.size(); i++) {
    id[g[i]] = i;
  }
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    sum = cnt = 0;
    query(0, id[a[i].second], 0, g.size() - 1);
    ans += abs(sum - cnt * a[i].first);
    update(id[a[i].second], a[i].first, 0, g.size() - 1);
  }
  cout << ans << endl;
  return 0;
}
