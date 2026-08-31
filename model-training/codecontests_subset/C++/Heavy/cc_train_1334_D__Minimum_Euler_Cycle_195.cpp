#include <bits/stdc++.h>
using namespace std;
using namespace std;
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int gcdExtended(long long int a, long long int b, long long int *x,
                          long long int *y) {
  if (a == 0) {
    *x = 0;
    *y = 1;
    return b;
  }
  long long int x1, y1;
  long long int gcd = gcdExtended(b % a, a, &x1, &y1);
  *x = y1 - (b / a) * x1;
  *y = x1;
  return gcd;
}
long long int mod = 1000000007;
long long int binpower(long long int a, long long int b) {
  long long int ans = 1;
  while (b > 0) {
    if (b & 1) ans = (ans * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return ans;
}
bool isPrime(int n) {
  for (int i = 2; i * i <= n; ++i) {
    if (n % i == 0) return false;
  }
  return true;
}
long long int fact[1005];
void factcalc() {
  fact[0] = 1;
  fact[1] = 1;
  for (long long int i = 2; i < 1005; ++i) {
    fact[i] = (fact[i - 1] * i) % mod;
  }
}
long long int C(int u, int v) {
  long long int c = (fact[v] * fact[u - v]) % mod;
  long long int in = binpower(c, mod - 2);
  long long int res = (in * fact[u]) % mod;
  return res;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int test = 1;
  cin >> test;
  while (test--) {
    int n;
    long long int l, r;
    cin >> n >> l >> r;
    long long int curr = 0;
    bool fl = false;
    for (int i = 0; i < n - 1; ++i) {
      long long int adder = 0;
      if (i == 0)
        adder = 2 * (n - 1);
      else
        adder = 2 * (n - i - 1);
      if (curr + adder >= l) {
        fl = true;
        long long int surplus = (l - curr);
        long long int beg = surplus / 2;
        int f = i + 1, s = beg + i + 2;
        if (surplus % 2 == 0) {
          cout << i + 1 + beg << " ";
          if (surplus == adder) {
            f++;
            s = f + 1;
          }
          l++;
        }
        int turn = 0;
        while (l <= r) {
          if (turn == 0) {
            if (f == n) {
              cout << 1;
              break;
            }
            cout << f << " ";
            turn = 1;
            l++;
            continue;
          } else {
            cout << s << " ";
            s++;
            turn = 0;
            if (s == n + 1) {
              f++;
              s = f + 1;
            }
            l++;
            continue;
          }
        }
        break;
      }
      curr += adder;
    }
    if (!fl) cout << 1;
    cout << endl;
  }
  return 0;
}
