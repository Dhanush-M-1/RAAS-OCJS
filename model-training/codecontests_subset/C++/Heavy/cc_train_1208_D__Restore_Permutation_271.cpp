#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
const double EPS = 1e-9;
const long long MOD = (long long)(1e9 + 7);
const long long MAXV = (long long)(2e5 + 10);
const long long MAXE = (long long)(1e6 + 10);
long long seg[MAXV * 4];
long long lazy[MAXV * 4];
long long A[MAXV * 4];
void build(int n, int s, int e) {
  if (s + 1 == e) {
    seg[n] = A[s];
  } else {
    int m = (s + e) >> 1;
    build(n * 2, s, m);
    build(n * 2 + 1, m, e);
    seg[n] = min(seg[n * 2], seg[n * 2 + 1]);
  }
}
void add_lazy(int n, long long x) {
  lazy[n] += x;
  seg[n] += x;
}
void push(int n, int s, int e) {
  if (s + 1 == e) return;
  add_lazy(n * 2, lazy[n]);
  add_lazy(n * 2 + 1, lazy[n]);
  lazy[n] = 0;
}
void update(int n, int s, int e, int a, int b, long long x) {
  if (s >= b || e <= a) return;
  if (s >= a && e <= b)
    add_lazy(n, x);
  else {
    if (lazy[n]) push(n, s, e);
    int m = (s + e) >> 1;
    update(n * 2, s, m, a, b, x);
    update(n * 2 + 1, m, e, a, b, x);
    seg[n] = min(seg[n * 2], seg[n * 2 + 1]);
  }
}
int query(int n, int s, int e) {
  if (s + 1 == e)
    return s;
  else {
    if (lazy[n]) push(n, s, e);
    int m = (s + e) >> 1;
    long long ans;
    if (seg[n * 2] < seg[n * 2 + 1])
      ans = query(n * 2, s, m);
    else
      ans = query(n * 2 + 1, m, e);
    seg[n] = min(seg[n * 2], seg[n * 2 + 1]);
    return ans;
  }
}
int n;
long long ans[MAXV];
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> A[i];
  build(1, 0, n);
  long long curr = 1;
  for (int i = 0; i < n; i++) {
    int p = query(1, 0, n);
    ans[p] = curr;
    update(1, 0, n, p + 1, n, -curr);
    update(1, 0, n, p, p + 1, INF);
    curr++;
  }
  for (int i = 0; i < n; i++) cout << ans[i] << " ";
  cout << "\n";
  return 0;
}
