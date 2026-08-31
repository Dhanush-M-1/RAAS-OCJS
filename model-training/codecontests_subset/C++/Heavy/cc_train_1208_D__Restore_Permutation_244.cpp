#include <bits/stdc++.h>
using namespace std;
long long power(long long a, long long b) {
  long long res = 1;
  a = a % 1000000007;
  while (b > 0) {
    if (b & 1) {
      res = (res * a) % 1000000007;
      b--;
    }
    a = (a * a) % 1000000007;
    b >>= 1;
  }
  return res;
}
long long fermat_inv(long long y) { return power(y, 1000000007 - 2); }
long long gcd(long long a, long long b) { return (b == 0) ? a : gcd(b, a % b); }
long long sum[800050];
void build(long long a[], int v, int l, int r) {
  if (l == r)
    sum[v] = a[l];
  else {
    int m = (l + r) / 2;
    build(a, 2 * v, l, m);
    build(a, 2 * v + 1, m + 1, r);
    sum[v] = sum[2 * v] + sum[2 * v + 1];
  }
}
long long query(int v, int tl, int tr, int l, int r) {
  if (l > r)
    return 0;
  else if (l == tl && r == tr)
    return sum[v];
  else {
    int m = (tl + tr) / 2;
    return query(2 * v, tl, m, l, min(r, m)) +
           query(2 * v + 1, m + 1, tr, max(l, m + 1), r);
  }
}
void update(int v, int l, int r, int pos, int val) {
  if (l == r)
    sum[v] = val;
  else {
    int m = (l + r) / 2;
    if (pos <= m)
      update(2 * v, l, m, pos, val);
    else
      update(2 * v + 1, m + 1, r, pos, val);
    sum[v] = sum[2 * v] + sum[2 * v + 1];
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) {
    int n;
    cin >> n;
    long long b[n];
    long long a[n + 1];
    a[0] = 0;
    for (int i = 0; i < n; i++) {
      cin >> b[i];
      a[i + 1] = i + 1;
    }
    build(a, 1, 0, n);
    for (int i = n - 1; i >= 0; i--) {
      long long l = 0;
      long long r = n;
      long long pos = -1;
      while (l <= r) {
        long long m = (l + r) / 2;
        long long val = query(1, 0, n, 0, m);
        if (val <= b[i]) {
          pos = m;
          l = m + 1;
        } else
          r = m - 1;
      }
      b[i] = pos + 1;
      update(1, 0, n, pos + 1, 0);
    }
    for (int i = 0; i < n; i++) {
      cout << b[i] << " ";
    }
    cout << "\n";
  }
  return 0;
}
