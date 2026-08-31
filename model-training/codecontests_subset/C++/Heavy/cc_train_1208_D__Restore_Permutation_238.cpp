#include <bits/stdc++.h>
using namespace std;
const long long N = 3e5;
long long n, t[N], a[N], res[N];
set<long long> st;
void upd(long long i) {
  long long d = i;
  for (i; i < N; i |= i + 1) t[i] += d;
}
long long sum(long long l, long long r) {
  long long s = 0;
  for (; r >= 0; r &= r + 1, r--) s += t[r];
  l--;
  for (; l >= 0; l &= l + 1, l--) s -= t[l];
  return s;
}
long long f(long long x) {
  if (!sum(x, x))
    return (x * x + x) / 2 - sum(0, x) - x;
  else
    return (x * x + x) / 2 - sum(0, x);
}
signed main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (long long i = 0; i < n; ++i) {
    cin >> a[i];
    st.insert(i);
  }
  for (long long i = n - 1; i >= 0; i--) {
    long long l = 1, r = n, med;
    while (r - l > 1) {
      med = (r + l) / 2;
      if (f(med) > a[i])
        r = med;
      else
        l = med;
    }
    if (f(r) == a[i]) {
      res[i] = r;
      upd(r);
    } else {
      res[i] = l;
      upd(l);
    }
  }
  for (long long i = 0; i < n; ++i) cout << res[i] << ' ';
}
