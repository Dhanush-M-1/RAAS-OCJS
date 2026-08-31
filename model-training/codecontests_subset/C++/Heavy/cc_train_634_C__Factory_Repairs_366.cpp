#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1 << 18;
const int SIZE = MAXN << 1;
int A, B;
int SEG[SIZE][2];
int query(int i, int a, int b, int cur = 1, int l = 0, int r = MAXN) {
  if (b <= l || a >= r) return 0;
  if (a <= l && b >= r) return SEG[cur][i];
  int mid = (l + r) / 2;
  return query(i, a, b, cur * 2, l, mid) + query(i, a, b, cur * 2 + 1, mid, r);
}
void update(int x, int v, int cur = 1, int l = 0, int r = MAXN) {
  if (l + 1 == r) {
    SEG[cur][0] = min(SEG[cur][0] + v, B);
    SEG[cur][1] = min(SEG[cur][1] + v, A);
  } else {
    int mid = (l + r) / 2;
    if (x < mid)
      update(x, v, cur * 2, l, mid);
    else
      update(x, v, cur * 2 + 1, mid, r);
    SEG[cur][0] = SEG[cur * 2][0] + SEG[cur * 2 + 1][0];
    SEG[cur][1] = SEG[cur * 2][1] + SEG[cur * 2 + 1][1];
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  int N, K, Q;
  cin >> N >> K >> A >> B >> Q;
  for (int i = 0; i < Q; ++i) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, v;
      cin >> d >> v;
      --d;
      update(d, v);
    } else {
      int p;
      cin >> p;
      --p;
      cout << query(0, 0, p) + query(1, p + K, N) << '\n';
    }
  }
  return 0;
}
