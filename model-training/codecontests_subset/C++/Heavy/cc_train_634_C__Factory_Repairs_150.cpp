#include <bits/stdc++.h>
using namespace std;
vector<long long> ans;
const int N = 200000;
long long ta[6 * N];
long long tb[6 * N];
const int INF = 100000000;
long long n, k, a, b, q;
long long get_a(int v, int vl, int vr, int l, int r) {
  if (vl == l && vr == r) {
    return ta[v];
  }
  long long r1, r2;
  if (l >= r)
    return 0;
  else {
    int d = (vl + vr) / 2;
    r1 = get_a(2 * v + 1, vl, d, l, min(d, r));
    r2 = get_a(2 * v + 2, d, vr, max(d, l), r);
  }
  return r1 + r2;
}
long long get_b(int v, int vl, int vr, int l, int r) {
  if (vl == l && vr == r) {
    return tb[v];
  }
  long long r1, r2;
  if (l >= r)
    return 0;
  else {
    int d = (vl + vr) / 2;
    r1 = get_b(2 * v + 1, vl, d, l, min(d, r));
    r2 = get_b(2 * v + 2, d, vr, max(d, l), r);
  }
  return r1 + r2;
}
void put_a(int v, int vl, int vr, int l, int r, int add) {
  if (vl == l && vr == r) {
    ta[v] = min(a, add + ta[v]);
    return;
  }
  if (l >= r)
    return;
  else {
    int d = (vl + vr) / 2;
    put_a(2 * v + 1, vl, d, l, min(d, r), add);
    put_a(2 * v + 2, d, vr, max(d, l), r, add);
    ta[v] = ta[2 * v + 1] + ta[2 * v + 2];
  }
}
void put_b(int v, int vl, int vr, int l, int r, int add) {
  if (vl == l && vr == r) {
    tb[v] = min(b, add + tb[v]);
    return;
  }
  if (l >= r)
    return;
  else {
    int d = (vl + vr) / 2;
    put_b(2 * v + 1, vl, d, l, min(d, r), add);
    put_b(2 * v + 2, d, vr, max(d, l), r, add);
    tb[v] = tb[2 * v + 1] + tb[2 * v + 2];
  }
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < 6 * N; i++) {
    ta[i] = 0;
    tb[i] = 0;
  }
  for (int i = 0; i < q; i++) {
    int pq;
    cin >> pq;
    if (pq == 1) {
      int val, cnt;
      cin >> val >> cnt;
      val--;
      put_a(0, 0, n, val, val + 1, cnt);
      put_b(0, 0, n, val, val + 1, cnt);
    } else {
      int p;
      cin >> p;
      p--;
      int t = get_b(0, 0, n, 0, p);
      int t1 = get_a(0, 0, n, p + k, n);
      ans.push_back(t + t1);
    }
  }
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i] << endl;
    ;
  }
  return 0;
}
