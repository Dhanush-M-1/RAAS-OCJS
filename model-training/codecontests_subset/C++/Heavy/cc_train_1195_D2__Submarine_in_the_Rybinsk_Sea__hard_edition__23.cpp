#include <bits/stdc++.h>
using namespace std;
const int MAX = (int)1e6 + 5, p = 998244353;
int A[MAX], len[MAX], dig[13];
int e10[] = {1,         10,        100,       1000,      10000,
             100000,    1000000,   10000000,  100000000, 1755647,
             17556470,  175564700, 757402647, 586315999, 871938225,
             733427426, 346563789, 470904831, 716070898, 172998509};
int main() {
  int n;
  while (scanf("%d", &n) == 1) {
    for (int i = 0; i < n; i++) scanf("%d", &A[i]);
    for (int i = 0; i < 13; i++) dig[i] = 0;
    int gg = 0;
    for (int i = 0; i < n; i++) {
      int x = A[i], count = 0;
      while (x > 0) {
        int add = (x % 10ll) * (e10[2 * count] + e10[2 * count + 1]) % p;
        gg = (gg + add) % p;
        x /= 10;
        count++;
      }
      len[i] = count;
      dig[count]++;
    }
    for (int i = 10; i >= 0; i--) dig[i] += dig[i + 1];
    for (int i = 0; i < n; i++) {
      int x = A[i], count = 1, ex = 1;
      while (x > 0) {
        int add = (x % 10ll) * (dig[count] - 1ll) * e10[ex] % p;
        gg = (gg + add) % p;
        add = (x % 10ll) * (dig[count - 1] - 1ll) * e10[ex - 1] % p;
        gg = (gg + add) % p;
        for (int j = 1; j < count; j++) {
          add = (x % 10ll) * (dig[j] - dig[j + 1]) * e10[count + j - 1] % p;
          if (j < count - 1) add = (add + add) % p;
          gg = (gg + add) % p;
        }
        x /= 10;
        count++;
        ex += 2;
      }
    }
    printf("%d\n", gg);
  }
  return 0;
}
