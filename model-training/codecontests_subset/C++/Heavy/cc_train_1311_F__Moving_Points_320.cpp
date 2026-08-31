#include <bits/stdc++.h>
using namespace std;
void coordinatecompress(vector<int> &data) {
  int n = data.size();
  vector<pair<int, int> > tempdata(n);
  for (int i = 0; i < n; i++) tempdata[i] = {data[i], i};
  sort(tempdata.begin(), tempdata.end());
  data[tempdata[0].second] = 0;
  for (int i = 1; i < n; i++)
    data[tempdata[i].second] = data[tempdata[i - 1].second] +
                               (tempdata[i - 1].first != tempdata[i].first);
}
struct segTree {
  long long cnt, sum;
};
const int N = 2e5;
segTree tree[4 * N + 1], lazy[4 * N + 1];
void updt(int s, int e, int node, int l, int r, int val) {
  tree[node].sum += lazy[node].sum * (e - s + 1);
  tree[node].cnt += lazy[node].cnt * (e - s + 1);
  int mid = (s + e) / 2;
  if (s != e) {
    lazy[2 * node + 1].sum += lazy[node].sum;
    lazy[2 * node + 2].sum += lazy[node].sum;
    lazy[2 * node + 1].cnt += lazy[node].cnt;
    lazy[2 * node + 2].cnt += lazy[node].cnt;
  }
  lazy[node] = {0, 0};
  if (r < s || l > e) return;
  if (s >= l && e <= r) {
    tree[node].sum += val * (e - s + 1);
    tree[node].cnt += e - s + 1;
    if (s != e) {
      lazy[2 * node + 1].sum += val;
      lazy[2 * node + 2].sum += val;
      lazy[2 * node + 1].cnt++;
      ;
      lazy[2 * node + 2].cnt++;
      ;
    }
    return;
  }
  updt(s, mid, 2 * node + 1, l, r, val);
  updt(mid + 1, e, 2 * node + 2, l, r, val);
  tree[node].sum = tree[2 * node + 1].sum + tree[2 * node + 2].sum;
  tree[node].cnt = tree[2 * node + 1].cnt + tree[2 * node + 2].cnt;
}
segTree qry(int s, int e, int node, int i, int j) {
  tree[node].sum += lazy[node].sum * (e - s + 1);
  tree[node].cnt += lazy[node].cnt * (e - s + 1);
  int mid = (s + e) / 2;
  if (s != e) {
    lazy[2 * node + 1].sum += lazy[node].sum;
    lazy[2 * node + 2].sum += lazy[node].sum;
    lazy[2 * node + 1].cnt += lazy[node].cnt;
    lazy[2 * node + 2].cnt += lazy[node].cnt;
  }
  lazy[node] = {0, 0};
  if (e < i || s > j) return {0, 0};
  if (s >= i && e <= j) {
    return tree[node];
  }
  segTree ans1 = qry(s, mid, 2 * node + 1, i, j),
          ans2 = qry(mid + 1, e, 2 * node + 2, i, j);
  tree[node].sum = ans1.sum + ans2.sum;
  tree[node].cnt = ans1.cnt + ans2.cnt;
  return tree[node];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<pair<int, int> > point(n);
  vector<int> p(n), v(n), tmp, org(n);
  for (int i = 0; i < n; i++) cin >> p[i];
  for (int i = 0; i < n; i++) cin >> v[i];
  tmp = p;
  coordinatecompress(p);
  for (int i = 0; i < n; i++) {
    org[p[i]] = tmp[i];
    point[i] = {v[i], p[i]};
  }
  long long ans = 0;
  sort(point.begin(), point.end());
  for (auto [s, x] : point) {
    segTree res = qry(0, n - 1, 0, x, x);
    ans += res.cnt * org[x] - res.sum;
    updt(0, n - 1, 0, x + 1, n - 1, org[x]);
  }
  cout << ans;
  return 0;
}
