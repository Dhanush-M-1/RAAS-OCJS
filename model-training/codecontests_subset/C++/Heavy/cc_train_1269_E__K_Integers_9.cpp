#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 5;
long long c[maxn], d[maxn];
long long n;
long long lowbit(long long x) { return x & (-x); }
void update(long long i, long long k) {
  while (i <= n) {
    c[i] += k;
    i += lowbit(i);
  }
}
long long getsum(long long i) {
  long long res = 0;
  while (i > 0) {
    res += c[i];
    i -= lowbit(i);
  }
  return res;
}
void update2(long long i, long long k) {
  while (i <= n) {
    d[i] += k;
    i += lowbit(i);
  }
}
long long getsum2(long long i) {
  long long res = 0;
  while (i > 0) {
    res += d[i];
    i -= lowbit(i);
  }
  return res;
}
long long f[maxn], where[maxn];
long long bs(long long sum) {
  long long l = 0, r = n;
  while (l <= r) {
    long long mid = (l + r) >> 1;
    if (getsum2(mid) >= sum)
      r = mid - 1;
    else
      l = mid + 1;
  }
  return l;
}
long long dc(long long x, long long y) {
  long long len = y - x + 1;
  return (x + y) * len / 2;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (long long i = 1; i <= n; ++i) {
    cin >> f[i];
    where[f[i]] = i;
  }
  long long cnt = 0;
  for (long long i = 1; i <= n; ++i) {
    long long pos = where[i];
    update2(pos, 1);
    cnt += i - getsum2(pos);
    update(pos, pos);
    long long base = bs(i / 2 + 1);
    long long lmost = base - i / 2;
    long long rmost = base + i / 2 - ((i + 1) % 2);
    long long t = dc(lmost, base) - dc(base + 1, rmost);
    long long sum = 0;
    sum -= getsum(base);
    sum += getsum(n) - getsum(base);
    cout << sum + t + cnt << " ";
  }
  cout << endl;
  return 0;
}
