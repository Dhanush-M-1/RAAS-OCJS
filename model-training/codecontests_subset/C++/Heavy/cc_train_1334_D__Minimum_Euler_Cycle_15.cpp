#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
long long binpow(long long base, long long exp, int mod) {
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base) % mod;
    exp = exp >> 1;
    base = (base * base) % mod;
  }
  return res;
}
long long mod(long long x) {
  return ((x % 1000000007LL + 1000000007LL) % 1000000007LL);
}
long long add(long long a, long long b) { return mod(mod(a) + mod(b)); }
long long mul(long long a, long long b) { return mod(mod(a) * mod(b)); }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int check[n];
    check[0] = 2 * (n - 1);
    long long int temp = n - 1;
    for (int i = 1; i < n; i++) {
      temp--;
      if (i == n - 1) {
        check[i] = check[i - 1] + 1;
      } else {
        check[i] = check[i - 1] + 2 * temp;
      }
    }
    long long int val, offset;
    for (int i = 0; i < n; i++) {
      if (check[i] >= l) {
        val = i + 1;
        if (i == 0) {
          offset = val + l / 2 + l % 2;
        } else {
          offset = val + (l - check[i - 1]) / 2 + (l - check[i - 1]) % 2;
        }
        break;
      }
    }
    long long int ans[r - l + 1];
    long long int y = l;
    if (val == n) {
      cout << 1 << "\n";
    } else {
      for (; l <= r; l++) {
        if (l % 2 == 1) {
          cout << val << " ";
        } else {
          cout << offset << " ";
          if (offset == n) {
            val++;
            offset = val + 1;
          } else {
            offset++;
          }
          if (val == n) {
            break;
          }
        }
      }
      if (r == ((n) * (n - 1) + 1)) {
        cout << 1;
      }
      cout << "\n";
    }
  }
  return 0;
}
