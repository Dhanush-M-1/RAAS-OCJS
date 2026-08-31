#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:640000000")
using namespace std;
const double eps = 1e-9;
const double pi = acos(-1.0);
const int maxn = (int)2e5 + 10;
long long a[maxn];
int res[maxn];
long long t[4 * maxn];
void build(int idx, int l, int r) {
  if (l == r) {
    t[idx] = l;
  } else {
    int m = (l + r) >> 1;
    build(2 * idx, l, m);
    build(2 * idx + 1, m + 1, r);
    t[idx] = t[2 * idx] + t[2 * idx + 1];
  }
}
int get(int idx, int l, int r, long long sum) {
  if (l == r) return l;
  int m = (l + r) >> 1;
  if (t[2 * idx] > sum) {
    return get(2 * idx, l, m, sum);
  }
  return get(2 * idx + 1, m + 1, r, sum - t[2 * idx]);
}
void upd(int idx, int l, int r, int pos) {
  if (l == r) {
    t[idx] = 0;
  } else {
    int m = (l + r) >> 1;
    if (pos <= m) {
      upd(2 * idx, l, m, pos);
    } else {
      upd(2 * idx + 1, m + 1, r, pos);
    }
    t[idx] = t[2 * idx] + t[2 * idx + 1];
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) scanf("%I64d", &a[i]);
  build(1, 1, n);
  for (int i = n - 1; i >= 0; i--) {
    int val = get(1, 1, n, a[i]);
    res[i] = val;
    upd(1, 1, n, val);
  }
  for (int i = 0; i < n; i++) {
    printf("%d ", res[i]);
  }
  return 0;
}
