#include <bits/stdc++.h>
using namespace std;
const long long N = 200010;
long long tr1[N], tr2[N];
long long n;
long long c[N];
long long lowbit(long long x) { return x & -x; }
void ud(long long tr[], long long x, long long d) {
  for (long long i = x; i <= n; i += lowbit(i)) {
    tr[i] += d;
  }
}
long long qur(long long tr[], long long x) {
  long long ans = 0;
  for (long long i = x; i; i -= lowbit(i)) {
    ans += tr[i];
  }
  return ans;
}
long long get_pos(long long tr[], long long x) {
  long long l = 0, r = n;
  while (l < r) {
    long long mid = (l + r) >> 1;
    if (qur(tr, mid) >= x)
      r = mid;
    else
      l = mid + 1;
  }
  return l;
}
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long x;
    cin >> x;
    c[x] = i;
  }
  long long d = 0;
  for (long long i = 1; i <= n; i++) {
    ud(tr1, c[i], 1);
    ud(tr2, c[i], c[i]);
    d += (i - qur(tr1, c[i]));
    long long pos = get_pos(tr1, (i + 1) / 2);
    long long aa = (i - 1) / 2;
    long long bb = i / 2;
    long long t1 = (long long)aa * pos - (1 + aa) * aa / 2;
    long long t2 = (1ll + bb) * bb / 2 + bb * pos;
    long long q1 = qur(tr2, pos - 1);
    long long q2 = qur(tr2, n) - qur(tr2, pos);
    long long ans = q2 - t2 + t1 - q1;
    cout << (ans + d) << ' ';
  }
}
