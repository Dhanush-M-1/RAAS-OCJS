#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
const int mod = 998244353;
int a[N], cnt[100], sz[N];
long long pw[100];
int main() {
  int n;
  scanf("%d", &n);
  pw[0] = 1;
  for (int i = 1; i <= 30; i++) pw[i] = pw[i - 1] * 10 % mod;
  for (int i = 1; i <= n; i++) {
    scanf("%d", a + i);
    sz[i] = 0;
    int b = a[i];
    while (b) {
      sz[i]++;
      b /= 10;
    }
    cnt[sz[i]]++;
  }
  long long res = 0;
  for (int i = 1; i <= n; i++) {
    int b = a[i];
    int pos = 0;
    while (b) {
      int c = b % 10;
      b /= 10;
      pos++;
      for (int j = 1; j <= 10; j++) {
        if (j < pos) {
          res += c * cnt[j] * pw[pos + j - 1];
        } else {
          res += c * cnt[j] * pw[(pos - 1) * 2];
        }
        if (j <= pos) {
          res += c * cnt[j] * pw[pos + j - 1];
        } else {
          res += c * cnt[j] * pw[pos * 2 - 1];
        }
        res %= mod;
      }
    }
  }
  printf("%lld\n", res);
}
