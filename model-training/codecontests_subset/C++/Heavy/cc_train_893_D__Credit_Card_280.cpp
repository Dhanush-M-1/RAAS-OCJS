#include <bits/stdc++.h>
using namespace std;
void swap(long long* a, long long* b) {
  long long temp = *a;
  *a = *b;
  *b = temp;
}
struct no {
  long long sum, maxpre;
};
no t[4 * 100005];
void build(long long a[], long long v, long long st, long long en) {
  if (st == en) {
    t[v].sum = a[st];
    t[v].maxpre = a[st];
  } else {
    long long md = (st + en) / 2;
    build(a, 2 * v, st, md);
    build(a, 2 * v + 1, md + 1, en);
    t[v].sum = t[2 * v].sum + t[2 * v + 1].sum;
    t[v].maxpre = max(t[2 * v].maxpre, t[2 * v].sum + t[2 * v + 1].maxpre);
  }
}
no qry(long long v, long long st, long long en, long long l, long long r) {
  no res;
  res.sum = res.maxpre = 0 - 1000000007;
  if (st > r || en < l) {
    return res;
  }
  if (st >= l && en <= r) {
    return t[v];
  }
  long long md = (st + en) / 2;
  if (l > md) {
    return qry(2 * v + 1, md + 1, en, l, r);
  }
  if (r <= md) {
    return qry(2 * v, st, md, l, r);
  }
  no lf = qry(2 * v, st, md, l, r);
  no rg = qry(2 * v + 1, md + 1, en, l, r);
  res.sum = lf.sum + rg.sum;
  res.maxpre = max(lf.maxpre, lf.sum + rg.maxpre);
  return res;
}
int32_t main() {
  long long n, d;
  cin >> n >> d;
  long long a[n + 1];
  for (long long i = 1; i <= n; i++) cin >> a[i];
  build(a, 1, 1, n);
  long long sm = 0, days = 0;
  bool flag = true;
  for (long long i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (sm >= 0)
        ;
      else {
        long long mnm = qry(1, 1, n, i, n).maxpre;
        if (mnm < 0)
          ;
        else if (mnm > d) {
          flag = false;
          break;
        } else {
          sm = max(0LL, d - mnm);
          days++;
        }
      }
    } else {
      sm += a[i];
    }
    if (sm > d) {
      flag = false;
      break;
    }
  }
  if (flag)
    cout << days << '\n';
  else
    cout << -1 << '\n';
}
