#include <bits/stdc++.h>
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  std::cout << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  std::cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
using namespace std;
long long expo(long long base, long long exponent, long long mod) {
  long long ans = 1;
  while (exponent != 0) {
    if ((exponent & 1) == 1) {
      ans = ans * base;
      ans = ans % mod;
    }
    base = base * base;
    base %= mod;
    exponent >>= 1;
  }
  return ans % mod;
}
long long add(long long a, long long b) {
  return (a % 998244353 + b % 998244353) % 998244353;
}
long long sub(long long a, long long b) {
  return (a % 998244353 - b % 998244353 + 998244353) % 998244353;
}
long long mul(long long a, long long b) {
  return ((a % 998244353) * (b % 998244353)) % 998244353;
}
long long inverse(long long n, long long p) { return expo(n, p - 2, p); }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long i, j, n, m, k, cnt = 0, ans = 0, t = 1;
  long long ten[25] = {0};
  cin >> n;
  for (i = 0; i < 25; i++) ten[i] = expo(10, i, 998244353);
  long long d[11] = {0};
  vector<string> v(n);
  for (i = 0; i < n; i++) {
    cin >> v[i];
    d[v[i].length()]++;
  }
  for (i = 0; i < n; i++) {
    k = v[i].length();
    string s = v[i];
    for (j = 1; j < 11; j++) {
      long long val = 0, l;
      cnt = 0;
      for (l = s.length() - 1; l >= max(0LL, k - 1 - j); l--)
        val = add(val, mul((s[l] - '0'), ten[cnt])), cnt += 2;
      cnt--;
      while (l >= 0) val = add(val, mul((s[l] - '0'), ten[cnt])), cnt++, l--;
      ans = add(ans, mul(val, d[j]));
      val = 0, cnt = 1;
      for (l = s.length() - 1; l >= max(0LL, k - j); l--)
        val = add(val, mul((s[l] - '0'), ten[cnt])), cnt += 2;
      cnt--;
      while (l >= 0) val = add(val, mul((s[l] - '0'), ten[cnt])), cnt++, l--;
      ans = add(ans, mul(val, d[j]));
    }
  }
  return cout << ans, 0;
  return 0;
}
