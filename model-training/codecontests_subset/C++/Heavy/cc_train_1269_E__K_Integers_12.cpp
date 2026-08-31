#include <bits/stdc++.h>
using namespace std;
long long const inf = 1e9;
long long const mod = 1e9 + 7;
long double const eps = 1e-9;
long long bit[200005];
long long bit2[200005];
long long sumbit[200005];
long long n;
void update(long long k) {
  while (k <= 200000) {
    bit[k] += 1;
    k += k & -k;
  }
}
long long sum(long long k) {
  long long s = 0;
  while (k > 0) {
    s += bit[k];
    k -= k & -k;
  }
  return s;
}
void update2(long long k) {
  while (k <= 200000) {
    bit2[k] += 1;
    k += k & -k;
  }
}
long long sum2(long long k) {
  long long s = 0;
  while (k > 0) {
    s += bit2[k];
    k -= k & -k;
  }
  return s;
}
void update3(long long k, long long val) {
  while (k <= 200000) {
    sumbit[k] += val;
    k += k & -k;
  }
}
long long sum3(long long k) {
  long long s = 0;
  while (k > 0) {
    s += sumbit[k];
    k -= k & -k;
  }
  return s;
}
long long cinv(long long pos, long long num) {
  long long SUM = num - 1;
  SUM -= sum2(pos);
  update2(pos);
  return SUM;
}
int main() {
  cin >> n;
  long long a[n];
  long long pos[n + 1];
  for (int i = (0); i < (n); i++) {
    cin >> a[i];
    pos[a[i]] = i + 1;
  }
  long long inversions = 0;
  for (int i = (1); i < (n + 1); i++) {
    inversions += cinv(pos[i], i);
    update(pos[i]);
    update3(pos[i], pos[i]);
    long long k = 0;
    for (long long b = n / 2; b >= 1; b /= 2) {
      while (k + b <= n && sum(k + b) <= i / 2) k += b;
    }
    k++;
    long long l = sum(k - 1);
    long long r = sum(n) - sum(k);
    long long suml = sum3(k - 1);
    long long sumr = sum3(n) - sum3(k);
    long long ans = inversions + (long long)l * k - suml + sumr -
                    (long long)r * k - (long long)(l * (l + 1)) / 2 -
                    (long long)(r * (r + 1)) / 2;
    cout << ans << endl;
  }
  return 0;
}
