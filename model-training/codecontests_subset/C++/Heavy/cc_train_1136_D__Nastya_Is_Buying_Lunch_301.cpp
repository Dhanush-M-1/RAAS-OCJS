#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
mt19937 gen(time(0));
struct Node {
  int v, s;
  long long k;
  Node *l, *r;
  Node(int k = 0) : k(k), v(gen()), s(1), l(0), r(0) {}
  void pull() { s = (l ? l->s : 0) + (r ? r->s : 0) + 1; }
  void *operator new(size_t);
};
Node mem[5000000];
int top = 0;
void *Node::operator new(size_t) { return mem + top++; }
Node *merge(Node *a, Node *b) {
  if (!a) return b;
  if (!b) return a;
  if (a->v < b->v) {
    a->r = merge(a->r, b);
    a->pull();
    return a;
  } else {
    b->l = merge(a, b->l);
    b->pull();
    return b;
  }
}
void split(Node *cur, long long k, Node *&a, Node *&b) {
  if (!cur) {
    a = b = 0;
    return;
  }
  if (k <= cur->k) {
    b = cur;
    split(cur->l, k, a, b->l);
    b->pull();
  } else {
    a = cur;
    split(cur->r, k, a->r, b);
    a->pull();
  }
}
Node *insert(Node *root, long long k) {
  Node *tmp = new Node(k), *a, *b;
  split(root, k, a, b);
  return merge(merge(a, tmp), b);
}
Node *erase(Node *root, long long k) {
  Node *a, *b;
  split(root, k, a, root);
  split(root, k + 1, root, b);
  return merge(a, b);
}
vector<long long> bit;
long long sum(int x) {
  long long ret = 0;
  while (x) {
    ret += bit[x];
    x -= (x & -x);
  }
  return ret;
}
void inc(int x, long long v) {
  while (x < bit.size()) {
    bit[x] += v;
    x += (x & -x);
  }
}
vector<long long> arr, heap;
void build(int i, int l, int r) {
  if (l == r) {
    heap[i] = arr[l];
    return;
  }
  int m = (l + r) >> 1;
  build(((i << 1) + 1), l, m);
  build(((i << 1) + 2), m + 1, r);
  heap[i] = heap[((i << 1) + 1)] + heap[((i << 1) + 2)];
}
int p;
long long v;
void update(int i, int l, int r) {
  if (l == r) {
    heap[i] += v;
    return;
  }
  int m = (l + r) >> 1;
  if (p <= m)
    update(((i << 1) + 1), l, m);
  else
    update(((i << 1) + 2), m + 1, r);
  heap[i] = heap[((i << 1) + 1)] + heap[((i << 1) + 2)];
}
int ql, qr;
long long res;
void query(int i, int l, int r) {
  if (ql <= l && r <= qr) {
    res += heap[i];
    return;
  }
  int m = (l + r) >> 1;
  if (ql <= m) query(((i << 1) + 1), l, m);
  if (qr > m) query(((i << 1) + 2), m + 1, r);
}
long long powi(long long a, long long b) {
  long long ret = 1;
  for (; b; b >>= 1, a = a * a % 1000000007) {
    if (b & 1) ret = ret * a % 1000000007;
  }
  return ret;
}
long long inv(long long a) { return powi(a, 1000000007 - 2); }
int main() {
  cin.tie(0), ios::sync_with_stdio(0);
  int n, m;
  cin >> n >> m;
  vector<int> arr(n);
  for (int i = 0; i < n; i++) cin >> arr[i], --arr[i];
  vector<vector<int>> adj(n);
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    adj[a - 1].push_back(b - 1);
  }
  vector<bool> v(n, 0);
  v[arr[n - 1]] = 1;
  int ans = 0, cnt;
  for (int i = n - 2; i >= 0; i--) {
    cnt = 0;
    for (auto j : adj[arr[i]]) {
      if (v[j]) cnt++;
    }
    if (i + cnt + ans == n - 1)
      ans++;
    else
      v[arr[i]] = 1;
  }
  cout << ans << '\n';
  return 0;
}
