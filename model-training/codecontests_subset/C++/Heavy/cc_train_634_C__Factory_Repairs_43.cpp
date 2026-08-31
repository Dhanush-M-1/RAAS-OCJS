#include <bits/stdc++.h>
using namespace std;
struct node {
  long long l, r, c;
};
struct node up[200000 * 4];
struct node down[200000 * 4];
long long chang[200000 + 1];
long long upp[200000 + 1];
long long downp[200000 + 1];
long long n, k, a, b, q;
int bj, di, ai;
long long Construct(long long l, long long r, long long k, node *arr) {
  long long mid;
  if (l == r) {
    arr[k].l = arr[k].r = r;
    return 0ll;
  }
  mid = (l + r) / 2;
  arr[k].l = l;
  arr[k].r = r;
  return (arr[k].c = Construct(l, mid, 2 * k, arr) +
                     Construct(mid + 1, r, 2 * k + 1, arr));
}
void Deal(long long l, long long r, long long k, long long loc, long long num,
          node *arr) {
  long long mid;
  if (arr[k].l == arr[k].r && arr[k].l == loc) {
    arr[k].c = arr[k].c + num;
    return;
  }
  mid = (l + r) / 2;
  arr[k].c += num;
  if (loc <= mid) {
    Deal(l, mid, 2 * k, loc, num, arr);
  } else {
    Deal(mid + 1, r, 2 * k + 1, loc, num, arr);
  }
}
long long Query(long long l, long long r, long long k, node *arr) {
  long long mid;
  if (arr[k].l == l && arr[k].r == r) {
    return arr[k].c;
  }
  mid = (arr[k].l + arr[k].r) / 2;
  if (r <= mid) {
    return Query(l, r, 2 * k, arr);
  } else if (l > mid) {
    return Query(l, r, 2 * k + 1, arr);
  } else {
    return Query(l, mid, 2 * k, arr) + Query(mid + 1, r, 2 * k + 1, arr);
  }
}
int main() {
  cin >> n >> k >> a >> b >> q;
  Construct(1, n, 1, up);
  Construct(1, n, 1, down);
  long long ans;
  for (int i = 1; i <= q; i++) {
    cin >> bj;
    if (bj == 1) {
      cin >> di >> ai;
      chang[di] += ai;
      long long p;
      p = min(chang[di], a);
      if (p > upp[di]) {
        Deal(1, n, 1, di, p - upp[di], up);
        upp[di] = p;
      }
      p = min(chang[di], b);
      if (p > downp[di]) {
        Deal(1, n, 1, di, p - downp[di], down);
        downp[di] = p;
      }
    } else {
      cin >> di;
      ans = 0ll;
      if (di > 1) {
        ans += Query(1, di - 1, 1, down);
      }
      if (di + k <= n) {
        ans += Query(di + k, n, 1, up);
      }
      cout << ans << endl;
    }
  }
  return 0;
}
