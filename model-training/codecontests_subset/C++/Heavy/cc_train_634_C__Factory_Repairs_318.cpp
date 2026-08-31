#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
int seg[2][200010 * 4];
int bv[200010];
int av[200010];
void up(int spot, int ss, int se, int si) {
  if (spot < ss || spot > se || ss > se) return;
  if (spot == ss && spot == se) {
    seg[0][si] = bv[spot];
    seg[1][si] = av[spot];
    return;
  }
  int mid = (ss + se) / 2;
  if (spot <= mid) {
    up(spot, ss, mid, si * 2 + 1);
  } else {
    up(spot, mid + 1, se, si * 2 + 2);
  }
  seg[0][si] = seg[0][si * 2 + 1] + seg[0][si * 2 + 2];
  seg[1][si] = seg[1][si * 2 + 1] + seg[1][si * 2 + 2];
}
void update(int spot, int inc) {
  bv[spot] += inc;
  av[spot] += inc;
  bv[spot] = min(bv[spot], b);
  av[spot] = min(av[spot], a);
  up(spot, 1, n, 0);
}
int qu(int ind, int qs, int qe, int ss, int se, int si) {
  if (qs > qe || ss > se || qe < ss || qs > se) return 0;
  if (qs <= ss && se <= qe) {
    return seg[ind][si];
  }
  int mid = (ss + se) / 2;
  return qu(ind, qs, qe, ss, mid, si * 2 + 1) +
         qu(ind, qs, qe, mid + 1, se, si * 2 + 2);
}
int query(int ind, int qs, int qe) { return qu(ind, qs, qe, 1, n, 0); }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  fill(seg[0], seg[0] + 200010 * 4, 0);
  fill(seg[1], seg[1] + 200010 * 4, 0);
  fill(bv, bv + 200010, 0);
  fill(av, av + 200010, 0);
  cin >> n >> k >> a >> b >> q;
  int tp;
  int di, ai, pi;
  while (q--) {
    cin >> tp;
    if (tp == 1) {
      cin >> di >> ai;
      update(di, ai);
    } else {
      cin >> pi;
      int ans = query(0, 1, pi - 1) + query(1, pi + k, n);
      cout << ans << endl;
    }
  }
  cin >> tp;
}
