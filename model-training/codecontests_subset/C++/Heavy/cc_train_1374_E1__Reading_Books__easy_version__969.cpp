#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 998244353;
const long double PI = 3.14159265359;
const long long int INF = 1e9;
char salpha[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                   'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                   's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
char calpha[26] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                   'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                   'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
long long int gcd(long long int a, long long int b) {
  if (a == 0) {
    return b;
  }
  return gcd(b % a, a);
}
long long int exp(long long int b, long long int p) {
  if (p == 0) {
    return 1;
  } else if (p % 2 == 0) {
    return exp(b * b, p / 2);
  } else {
    return b * exp(b * b, (p - 1) / 2);
  }
}
long long int mexp(long long int b, long long int p) {
  if (p == 0) {
    return 1;
  } else if (p % 2 == 0) {
    return mexp((b * b) % MOD, p / 2) % MOD;
  } else {
    return (b * mexp((b * b) % MOD, (p - 1) / 2)) % MOD;
  }
}
long long int minv(long long int a) { return mexp(a, MOD - 2); }
int isprime(long long int n) {
  for (long long int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      return 0;
    }
  }
  return 1;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, k;
  cin >> n >> k;
  vector<int> a, b, c;
  for (int i = 0; i < n; i++) {
    int t, ap, bp;
    cin >> t >> ap >> bp;
    if (ap == 1 && bp == 1)
      c.push_back(t);
    else if (ap == 1)
      a.push_back(t);
    else if (bp == 1)
      b.push_back(t);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  if (a.size() + c.size() < k || b.size() + c.size() < k)
    cout << "-1"
         << "\n";
  else {
    int ai = 0, bi = 0, ci = 0;
    long long int ans = 0;
    for (int i = 0; i < k; i++) {
      long long int flag1 = -1, flag2 = -1;
      long long int opt1, opt2;
      if (ai != a.size() && bi != b.size()) {
        flag1 = 1;
        opt1 = a[ai] + b[bi];
        ai++;
        bi++;
      }
      if (ci != c.size()) {
        flag2 = 1;
        opt2 = c[ci];
        ci++;
      }
      if (flag1 == -1) {
        ans += opt2;
      } else if (flag2 == -1) {
        ans += opt1;
      } else if (flag1 == 1 && flag2 == 1) {
        if (opt1 < opt2) {
          ans += opt1;
          ci--;
        } else {
          ans += opt2;
          ai--;
          bi--;
        }
      }
    }
    cout << ans << "\n";
  }
}
