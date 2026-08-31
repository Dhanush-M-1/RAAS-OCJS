#include <bits/stdc++.h>
using namespace std;
int dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[8] = {1, -1, -1, 0, 1, -1, 0, 1};
long long tree[4 * 200005], lazy[4 * 200005], ans[4 * 200005], a[200005];
void build(long long int start, long long int last, long long int node) {
  if (start == last) {
    tree[node] = a[start];
    ans[node] = start;
    return;
  }
  long long int mid = (start + last) >> 1, l = node << 1;
  build(start, mid, l), build(mid + 1, last, l + 1);
  long long t1 = tree[l], t2 = tree[l + 1];
  if (t1 < t2)
    ans[node] = ans[l];
  else
    ans[node] = ans[l + 1];
  tree[node] = (tree[l] > tree[l + 1] ? tree[l + 1] : tree[l]);
  return;
}
void update(long long int start, long long int last, long long int l,
            long long int r, long long int node, long long val) {
  if (lazy[node]) {
    tree[node] += lazy[node];
    if (start != last) {
      lazy[node << 1] += lazy[node];
      lazy[(node << 1) + 1] += lazy[node];
    }
    lazy[node] = 0;
  }
  if (start > r || last < l) return;
  if (l <= start && r >= last) {
    tree[node] += val;
    if (start != last) {
      lazy[node << 1] += val;
      lazy[(node << 1) + 1] += val;
    }
    return;
  }
  long long int mid = (start + last) >> 1;
  update(start, mid, l, r, node << 1, val);
  update(mid + 1, last, l, r, (node << 1) + 1, val);
  if (tree[node << 1] < tree[(node << 1) + 1])
    ans[node] = ans[node << 1];
  else
    ans[node] = ans[(node << 1) + 1];
  tree[node] = (tree[node << 1] > tree[(node << 1) + 1] ? tree[(node << 1) + 1]
                                                        : tree[node << 1]);
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  long long int n1 = n, ans1[n + 1], cnt = 1;
  for (long long int i = 1; i <= n; i++) cin >> a[i];
  build(1, n, 1);
  while (n1--) {
    long long int idx = ans[1];
    ans1[idx] = cnt;
    update(1, n, idx, idx, 1, 1000000000000);
    if (idx < n) update(1, n, idx + 1, n, 1, -cnt);
    cnt++;
  }
  for (long long int i = 1; i <= n; i++) cout << ans1[i] << " ";
  return 0;
}
