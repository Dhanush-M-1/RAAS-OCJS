#include <bits/stdc++.h>
using namespace std;
const long MOD = 998244353;
unsigned long long duplicate(long x);
unsigned long long duplicate(long x, int len);
unsigned long long power(int x, int y);
int main() {
  long n;
  cin >> n;
  vector<long> a(n);
  long long ans = 0;
  for (long i = 0; i < n; ++i) scanf("%d", &a[i]);
  vector<int> dgts(11);
  for (long i = 0; i < n; ++i) ++dgts[(int)log10(a[i]) + 1];
  for (long i = 0; i < n; ++i) {
    for (int j = 1; j <= 10; ++j) {
      ans += dgts[j] * duplicate(a[i], j);
    }
  }
  printf("%llu", ans % MOD);
  return 0;
}
unsigned long long duplicate(long x) {
  string temp = to_string(x);
  string ans = "";
  for (int i = 0; i < temp.length(); ++i) {
    ans += temp[i];
    ans += temp[i];
  }
  return stoull(ans.c_str()) % MOD;
}
unsigned long long duplicate(long x, int len) {
  string temp = to_string(x);
  if (temp.size() <= len) {
    return duplicate(x);
  } else {
    return (2 * stoull(temp.substr(0, temp.length() - len)) *
            (unsigned long long)power(10, 2 * len)) %
               MOD +
           duplicate(stoull(temp.substr(temp.length() - len)));
  }
}
unsigned long long power(int x, int y) {
  unsigned long long ans = 1;
  for (int i = 0; i < y; ++i) ans *= x;
  return ans;
}
