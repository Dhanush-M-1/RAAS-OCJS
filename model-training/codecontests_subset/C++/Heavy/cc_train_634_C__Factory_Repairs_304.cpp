#include <bits/stdc++.h>
long long dbg = 1;
using namespace std;
long long n, k, a, b, q;
long long t[2 * 200005], t1[2 * 200005];
void update(long long d, long long k) {
  d += n;
  t[d] = min(t[d] + k, a);
  d /= 2;
  while (d) {
    t[d] = t[2 * d] + t[2 * d + 1];
    d /= 2;
  }
}
void update2(long long d, long long k) {
  d += n;
  t1[d] = min(t1[d] + k, b);
  d /= 2;
  while (d) {
    t1[d] = t1[2 * d] + t1[2 * d + 1];
    d /= 2;
  }
}
long long query(long long c, long long d) {
  c += n;
  d += n;
  long long ans = 0;
  while (c < d) {
    if (c % 2) ans += t[c++];
    if (d % 2) ans += t[--d];
    c /= 2;
    d /= 2;
  }
  return ans;
}
long long query2(long long c, long long d) {
  c += n;
  d += n;
  long long ans = 0;
  while (c < d) {
    if (c % 2) ans += t1[c++];
    if (d % 2) ans += t1[--d];
    c /= 2;
    d /= 2;
  }
  return ans;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  long long c, d, e;
  while (q--) {
    cin >> c >> d;
    d--;
    if (c == 1) {
      cin >> e;
      update(d, e);
      update2(d, e);
    } else {
      cout << query2(0, d) + query(d + k, n) << endl;
    }
  }
  return 0;
}
