#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int segA[4 * N];
int aaaa[N];
int segB[4 * N];
int n, k, a, b, q;
void update(int idx, int l, int r, int ql, int qr, int v) {
  if (l > r or l > qr or r < ql) return;
  if (l >= ql and r <= qr) {
    segA[idx] = min(b, v);
    segB[idx] = min(a, v);
    return;
  }
  int mid = (l + r) / 2;
  update(idx + idx, l, mid, ql, qr, v);
  update(idx + idx + 1, mid + 1, r, ql, qr, v);
  segA[idx] = segA[idx + idx] + segA[idx + idx + 1];
  segB[idx] = segB[idx + idx] + segB[idx + idx + 1];
}
int queryA(int idx, int l, int r, int ql, int qr) {
  if (l > r or l > qr or r < ql) return 0;
  if (l >= ql and r <= qr) {
    return segA[idx];
  }
  int mid = (l + r) / 2;
  return queryA(idx + idx, l, mid, ql, qr) +
         queryA(idx + idx + 1, mid + 1, r, ql, qr);
}
int queryB(int idx, int l, int r, int ql, int qr) {
  if (l > r or l > qr or r < ql) return 0;
  if (l >= ql and r <= qr) {
    return segB[idx];
  }
  int mid = (l + r) / 2;
  return queryB(idx + idx, l, mid, ql, qr) +
         queryB(idx + idx + 1, mid + 1, r, ql, qr);
}
int main() {
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int x;
    scanf("%d", &x);
    if (x == 1) {
      int y, z;
      scanf("%d%d", &y, &z);
      aaaa[y] += z;
      update(1, 1, n, y, y, aaaa[y]);
    } else {
      int z;
      scanf("%d", &z);
      int hi = z + k - 1;
      if (hi > n) hi = n;
      int fi = 0;
      if (z > 1) {
        fi = queryA(1, 1, n, 1, z - 1);
      }
      int si = 0;
      if (hi < n) {
        si = queryB(1, 1, n, hi + 1, n);
      }
      printf("%d", si + fi);
      printf("\n");
    }
  }
}
