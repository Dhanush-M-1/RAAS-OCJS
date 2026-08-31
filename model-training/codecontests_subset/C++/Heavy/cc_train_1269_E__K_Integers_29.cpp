#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  return (b == 0 ? a : gcd(b, a % b));
}
char vow[] = {'a', 'e', 'i', 'o', 'u'};
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
const int N = 4e5 + 30;
const long long int mod = -1e11;
int n;
int tx[N];
set<long long int> s;
long long int t1[4 * N], t2[4 * N], t3[4 * N];
long long int flag1[4 * N], flag2[4 * N], flag3[4 * N];
long long int inv;
void push(int nd) {
  t1[nd] += flag1[nd];
  flag1[nd * 2] += flag1[nd];
  flag1[nd * 2 + 1] += flag1[nd];
  flag1[nd] = 0;
  t2[nd] += flag2[nd];
  flag2[nd * 2] += flag2[nd];
  flag2[nd * 2 + 1] += flag2[nd];
  flag2[nd] = 0;
  t3[nd] += flag3[nd];
  flag3[nd * 2] += flag3[nd];
  flag3[nd * 2 + 1] += flag3[nd];
  flag3[nd] = 0;
}
void upd1(int ql, int qr, long long int v, int nl = 1, int nr = n, int nd = 1) {
  push(nd);
  if (ql > nr || qr < nl) return;
  if (ql == nl && qr == nr) {
    flag1[nd] += v;
    push(nd);
    return;
  }
  int mid = (nl + nr) / 2;
  upd1(ql, min(mid, qr), v, nl, mid, nd * 2);
  upd1(max(mid + 1, ql), qr, v, mid + 1, nr, nd * 2 + 1);
}
long long int qry1(int q, int nl = 1, int nr = n, int nd = 1) {
  push(nd);
  if (q > nr || q < nl) return 0;
  if (nl == nr) {
    return t1[nd];
  }
  int mid = (nl + nr) / 2;
  return qry1(q, nl, mid, nd * 2) + qry1(q, mid + 1, nr, nd * 2 + 1);
}
void upd2(int ql, int qr, long long int v, int nl = 1, int nr = n, int nd = 1) {
  push(nd);
  if (ql > nr || qr < nl) return;
  if (ql == nl && qr == nr) {
    flag2[nd] += v;
    push(nd);
    return;
  }
  int mid = (nl + nr) / 2;
  upd2(ql, min(mid, qr), v, nl, mid, nd * 2);
  upd2(max(mid + 1, ql), qr, v, mid + 1, nr, nd * 2 + 1);
}
long long int qry2(int q, int nl = 1, int nr = n, int nd = 1) {
  push(nd);
  if (q > nr || q < nl) return 0;
  if (nl == nr) {
    return t2[nd];
  }
  int mid = (nl + nr) / 2;
  return qry2(q, nl, mid, nd * 2) + qry2(q, mid + 1, nr, nd * 2 + 1);
}
void upd3(int ql, int qr, long long int v, int nl = 1, int nr = n, int nd = 1) {
  push(nd);
  if (ql > nr || qr < nl) return;
  if (ql == nl && qr == nr) {
    flag3[nd] += v;
    push(nd);
    return;
  }
  int mid = (nl + nr) / 2;
  upd3(ql, min(mid, qr), v, nl, mid, nd * 2);
  upd3(max(mid + 1, ql), qr, v, mid + 1, nr, nd * 2 + 1);
}
long long int qry3(int q, int nl = 1, int nr = n, int nd = 1) {
  push(nd);
  if (q > nr || q < nl) return 0;
  if (nl == nr) {
    return t3[nd];
  }
  int mid = (nl + nr) / 2;
  return qry3(q, nl, mid, nd * 2) + qry3(q, mid + 1, nr, nd * 2 + 1);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  ;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    tx[a] = i + 1;
  }
  for (int i = 1; i <= n; i++) {
    upd2(tx[i], n, 1);
    long long int l = 1, r = n, ind = 0;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (qry2(mid) >= (i + 1) / 2) {
        ind = mid;
        r = mid - 1;
      } else
        l = mid + 1;
    }
    long long int s = (i + 1) / 2;
    long long int sum = s * ind - ((s - 1LL) * s) / 2LL;
    if (tx[i] == 1)
      upd1(tx[i], n, -tx[i]);
    else {
      upd1(1, tx[i] - 1, tx[i]);
      upd1(tx[i], n, -tx[i]);
    }
    inv += qry3(tx[i]);
    upd3(1, tx[i], 1);
    long long int ans = inv + sum + qry1(ind);
    ind += i - (i + 1LL) / 2LL;
    sum = i * ind - ((i - 1LL) * 1LL * i) / 2LL - sum;
    ans -= sum;
    cout << ans << " ";
  }
  return 0;
}
