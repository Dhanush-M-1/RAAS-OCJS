#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC optimize("no-stack-protector")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,popcnt,abm,mmx,tune=native")
const long long MOD = 998244353;
long long gcd(long long a, long long b) {
  if (a < b) {
    swap(a, b);
  }
  while (b != 0) {
    long long tmp = b;
    b = a % b;
    a = tmp;
  }
  return a;
}
signed main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);
  long long t = 1;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    l--;
    long long cur_plus = 0;
    long long org = (n - 1) * 2;
    long long prev_org = 0;
    while (org < l) {
      n--;
      prev_org = org;
      org += (n - 1) * 2;
      cur_plus++;
    }
    while (l < r) {
      if (l % 2 == 1) {
        cout << (l - prev_org) / 2 + 2 + cur_plus << ' ';
        l++;
      }
      for (l = l; l < r && l < org; l += 2) {
        cout << 1 + cur_plus << ' ';
        if (l + 1 < r) {
          cout << (l - prev_org) / 2 + 2 + cur_plus << ' ';
        }
      }
      n--;
      prev_org = org;
      org += (n - 1) * 2;
      if (n == 1 && l < r) {
        cout << 1 << ' ';
        break;
      }
      if (n == 1) {
        break;
      }
      cur_plus++;
    }
    cout << "\n" << endl;
  }
}
