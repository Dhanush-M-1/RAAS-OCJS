#include <bits/stdc++.h>
using namespace std;
int n;
long long ar[200005];
long long tree[800005];
long long valr[800005];
long long lazy[800005];
long long ans[200005];
int gl = 0;
long long h;
void build(int node, int start, int end) {
  if (start == end) {
    tree[node] = ar[start];
    valr[node] = start;
  } else {
    int mid = (start + end) / 2;
    build(2 * node, start, mid);
    build(2 * node + 1, mid + 1, end);
    tree[node] = min(tree[node * 2], tree[node * 2 + 1]);
    if (tree[node * 2 + 1] == tree[node])
      valr[node] = valr[node * 2 + 1];
    else
      valr[node] = valr[node * 2];
  }
}
void updateRange(int node, long long start, long long end, int l, long long r,
                 long long val) {
  if (lazy[node] != 0) {
    tree[node] -= lazy[node];
    if (start != end) {
      lazy[node * 2] += lazy[node];
      lazy[node * 2 + 1] += lazy[node];
    }
    lazy[node] = 0;
  }
  if (start > end or start > r or end < l) return;
  if (start >= l and end <= r) {
    tree[node] -= val;
    if (start != end) {
      lazy[node * 2] += val;
      lazy[node * 2 + 1] += val;
    }
    if (start == end && gl) {
      valr[node] = h;
    }
    lazy[node] = 0;
    return;
  }
  int mid = (start + end) / 2;
  updateRange(node * 2, start, mid, l, r, val);
  updateRange(node * 2 + 1, mid + 1, end, l, r, val);
  tree[node] = min(tree[node * 2], tree[node * 2 + 1]);
  if (tree[node * 2 + 1] == tree[node])
    valr[node] = valr[node * 2 + 1];
  else
    valr[node] = valr[node * 2];
}
pair<long long, long long> queryRange(int node, int start, int end, int l,
                                      int r) {
  if (start > end or start > r or end < l) return {10004000000, -1};
  if (lazy[node] != 0) {
    tree[node] -= lazy[node];
    if (start != end) {
      lazy[node * 2] += lazy[node];
      lazy[node * 2 + 1] += lazy[node];
    }
    lazy[node] = 0;
  }
  if (start >= l and end <= r) return {tree[node], valr[node]};
  int mid = (start + end) / 2;
  pair<int, int> p1 = queryRange(node * 2, start, mid, l, r);
  pair<int, int> p2 = queryRange(node * 2 + 1, mid + 1, end, l, r);
  if (p2.first <= p1.first) return p2;
  return p1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> ar[i];
  gl = 1;
  build(1, 0, n - 1);
  gl = 0;
  for (int i = 0; i < n; i++) {
    pair<long long, long long> h = queryRange(1, 0, n - 1, 0, n - 1);
    ans[h.second] = i + 1;
    updateRange(1, 0, n - 1, h.second + 1, n - 1, i + 1);
    updateRange(1, 0, n - 1, h.second, h.second, -200000000000);
  }
  for (int i = 0; i < n; i++) cout << ans[i] << " ";
  return 0;
}
