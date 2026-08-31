#include <bits/stdc++.h>
using namespace std;
template <typename A, typename B>
ostream &operator<<(ostream &s, const pair<A, B> &p) {
  return s << "(" << p.first << "," << p.second << ")";
}
template <typename T>
ostream &operator<<(ostream &s, const vector<T> &c) {
  s << "[ ";
  for (auto it : c) s << it << " ";
  s << "]";
  return s;
}
const int MAXN = 262144;
int N, K, A, B, Q;
int arr[MAXN];
int na[MAXN], nb[MAXN];
int sega[MAXN * 2], segb[MAXN * 2];
void update_seg(int s, int lb, int rb, int pos, int va, int vb) {
  if (pos < lb || pos >= rb) return;
  if (rb - lb == 1) {
    sega[s] = va;
    segb[s] = vb;
  } else {
    int mb = (lb + rb) >> 1;
    update_seg(2 * s, lb, mb, pos, va, vb);
    update_seg(2 * s + 1, mb, rb, pos, va, vb);
    sega[s] = sega[2 * s] + sega[2 * s + 1];
    segb[s] = segb[2 * s] + segb[2 * s + 1];
  }
}
int qry_seg(int s, int lb, int rb, int l, int r, bool type) {
  if (rb <= l || r <= lb) return 0;
  if (l <= lb && rb <= r) {
    if (type)
      return sega[s];
    else
      return segb[s];
  } else {
    int mb = (lb + rb) >> 1;
    return qry_seg(2 * s, lb, mb, l, r, type) +
           qry_seg(2 * s + 1, mb, rb, l, r, type);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> K >> A >> B >> Q;
  for (int i = 0; i < Q; i++) {
    int ty;
    cin >> ty;
    if (ty == 1) {
      int d, a;
      cin >> d >> a;
      d--;
      na[d] = min(A, na[d] + a);
      nb[d] = min(B, nb[d] + a);
      update_seg(1, 0, N, d, na[d], nb[d]);
    } else {
      int p;
      cin >> p;
      p--;
      int ans = qry_seg(1, 0, N, 0, p, 0) + qry_seg(1, 0, N, p + K, N, 1);
      cout << ans << "\n";
    }
  }
  return 0;
}
