#include <bits/stdc++.h>
using namespace std;
unsigned long long i, j;
const unsigned long long mod = 998244353;
unsigned long long n, Q, T, m, k, r, x;
unsigned long long a[100001], used[2][10][100001], q[100001];
unsigned long long cnt[25];
unsigned long long dig;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  memset(cnt, 0, sizeof(cnt));
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n; i++) {
    dig = 0;
    unsigned long long x = a[i];
    while (x) {
      x /= 10;
      dig++;
    }
    cnt[dig]++;
    q[i] = dig;
  }
  for (i = 0; i < n; i++) {
    for (dig = 1; dig < 11; dig++) {
      unsigned long long x = a[i], newx = 0, pow = 1, cnt = 0;
      while (x) {
        pow *= 10;
        newx += pow * (x % 10);
        x /= 10;
        cnt++;
        if (cnt < dig) pow *= 10;
      }
      newx = newx % mod;
      used[0][dig][i] = newx;
    }
  }
  for (i = 0; i < n; i++) {
    for (dig = 1; dig < 11; dig++) {
      unsigned long long x = a[i], newx = 0, pow = 1, cnt = 0;
      while (x) {
        newx += pow * (x % 10);
        x /= 10;
        cnt++;
        pow *= 10;
        if (cnt <= dig) pow *= 10;
      }
      newx = newx % mod;
      used[1][dig][i] = newx;
    }
  }
  unsigned long long ans = 0;
  for (i = 0; i < n; i++) {
    for (dig = 1; dig < 11; dig++) {
      ans += (cnt[dig] * used[0][dig][i]) % mod;
      ans += (cnt[dig] * used[1][dig][i]) % mod;
    }
  }
  cout << ans % mod << endl;
}
