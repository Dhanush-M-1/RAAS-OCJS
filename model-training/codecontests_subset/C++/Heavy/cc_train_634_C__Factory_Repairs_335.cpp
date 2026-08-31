#include <bits/stdc++.h>
using namespace std;
vector<int> ta, tb;
int n, k, a, b, q;
void builda(int node, int s, int e, int idx, int val) {
  if (s == e) {
    ta[node] = min(ta[node] + val, a);
  } else {
    int mid = (s + e) / 2;
    if ((s <= idx) && (mid >= idx))
      builda(2 * node, s, mid, idx, val);
    else
      builda(2 * node + 1, mid + 1, e, idx, val);
    ta[node] = ta[2 * node] + ta[2 * node + 1];
  }
}
void buildb(int node, int s, int e, int idx, int val) {
  if (s == e) {
    tb[node] = min(tb[node] + val, b);
  } else {
    int mid = (s + e) / 2;
    if ((s <= idx) && (mid >= idx))
      buildb(2 * node, s, mid, idx, val);
    else
      buildb(2 * node + 1, mid + 1, e, idx, val);
    tb[node] = tb[2 * node] + tb[2 * node + 1];
  }
}
int quarya(int node, int s, int e, int l, int r) {
  if ((r < s) || (e < l))
    return 0;
  else if ((l <= s) && (e <= r))
    return ta[node];
  int mid = (s + e) / 2;
  int c1 = quarya(2 * node, s, mid, l, r);
  int c2 = quarya(2 * node + 1, mid + 1, e, l, r);
  return c1 + c2;
}
int quaryb(int node, int s, int e, int l, int r) {
  if ((r < s) || (e < l))
    return 0;
  else if ((l <= s) && (e <= r))
    return tb[node];
  int mid = (s + e) / 2;
  int c1 = quaryb(2 * node, s, mid, l, r);
  int c2 = quaryb(2 * node + 1, mid + 1, e, l, r);
  return c1 + c2;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  ta.resize(n * 4);
  tb.resize(n * 4);
  int x, y, z;
  for (int i = 0; i < q; i++) {
    cin >> x;
    if (x == 1) {
      cin >> y >> z;
      builda(1, 1, n, y, min(a, z));
      buildb(1, 1, n, y, min(b, z));
    } else {
      cin >> y;
      cout << quaryb(1, 1, n, 1, y - 1) + quarya(1, 1, n, y + k, n) << endl;
    }
  }
  return 0;
}
