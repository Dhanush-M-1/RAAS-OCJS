#include <bits/stdc++.h>
using namespace std;
int arr1[1000][1000];
void qwerty() {
  for (int k = 0; k < 100; k++)
    ;
}
void asdfgh() {
  for (int k = 0; k < 100; k++)
    ;
}
long long a1[200005];
long long b1[200005];
long long t1[500005], t2[500005];
long long n, a, b;
void zxcvb(long long p, long long value) {
  long long p1 = p;
  long long p2 = p;
  p1 += n;
  p2 += n;
  for (t1[p1] = min(t1[p1] + value, a); p1 > 1; p1 >>= 1) {
    t1[p1 >> 1] = t1[p1] + t1[p1 ^ 1];
  }
  for (t2[p2] = min(t2[p2] + value, b); p2 > 1; p2 >>= 1) {
    t2[p2 >> 1] = t2[p2] + t2[p2 ^ 1];
  }
}
long long yuiop(long long l, long long r) {
  long long res = 0;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l & 1) res += t1[l++];
    if (r & 1) res += t1[--r];
  }
  return res;
}
long long poiuy(long long l, long long r) {
  long long res = 0;
  for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
    if (l & 1) res += t2[l++];
    if (r & 1) res += t2[--r];
  }
  return res;
}
int main() {
  long long k, q, i, ch, d, x, p, ans;
  cin >> n >> k >> b >> a >> q;
  qwerty();
  for (i = 0; i < q; i++) {
    cin >> ch;
    asdfgh();
    if (ch == 1) {
      cin >> d;
      d--;
      cin >> x;
      zxcvb(d, x);
      qwerty();
    } else {
      ans = 0;
      cin >> p;
      p--;
      ans += yuiop(0, p);
      ans += poiuy(p + k, n);
      cout << ans << endl;
    }
  }
}
