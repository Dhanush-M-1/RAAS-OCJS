#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long m = 998244353) {
  if (y == 0) return 1;
  long long p = power(x, y / 2, m) % m;
  p = (p * p) % m;
  return (y % 2 == 0) ? p : (x * p) % m;
}
long long sum(string s, long long l, long long num) {
  if (num == 0) return 0;
  long long ans = 0;
  long long curr_len = s.size();
  long long total_len = curr_len + l;
  long long maxl = min(l, curr_len) * 2;
  long long bar = 0;
  if (curr_len > l) {
    while (curr_len > l) {
      ans += ((((((s[bar] - '0') *
                  ((long long)power(10, total_len - 1) % 998244353)) %
                 998244353) *
                num) %
               998244353) *
              2) %
             998244353;
      ans %= 998244353;
      bar++;
      total_len--;
      curr_len--;
    }
  }
  while (maxl > 0) {
    ans += ((((s[bar] - '0') * ((long long)power(10, maxl - 1)) % 998244353) %
             998244353) *
            num) %
           998244353;
    ans += ((((s[bar] - '0') * ((long long)power(10, maxl - 2)) % 998244353) %
             998244353) *
            num) %
           998244353;
    maxl -= 2;
    bar++;
  }
  return ans;
}
signed main() {
  long long n;
  cin >> n;
  string a[n];
  long long nums[11] = {0};
  for (long long i = 0; i <= n - 1; i++) {
    cin >> a[i];
    nums[a[i].size()]++;
  }
  long long ans = 0;
  for (long long i = 0; i <= n - 1; i++) {
    for (long long len = 1; len <= 10; len++) {
      ans = (ans + sum(a[i], len, nums[len])) % 998244353;
    }
  }
  cout << ans << "\n";
}
