#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
long long int mod = 1000000007;
long long int inf = 1000000000000000010;
long long int ninf = -1000000000000000010;
double PI = 3.141592654;
template <typename T>
inline T gcd(T a, T b) {
  T t;
  if (a < b) {
    while (a) {
      t = a;
      a = b % a;
      b = t;
    }
    return b;
  } else {
    while (b) {
      t = b;
      b = a % b;
      a = t;
    }
    return a;
  }
}
long long int power(long long int x, long long int y) {
  long long int ans = 1;
  while (y > 0) {
    if (y & 1) ans = (ans * x) % mod;
    x = (x * x) % mod;
    y = y >> 1;
  }
  return ans;
}
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
long long int arr[100010] = {0}, maxi[100010] = {0}, cum[100010] = {0};
int main() {
  long long int n, d, cnt = 0, sum = 0;
  scanf("%lld%lld", &n, &d);
  for (long long int i = (0); i < (n); i++) {
    scanf("%lld", &arr[i]);
    cum[i] = cum[max(0ll, i - 1)] + arr[i];
  }
  maxi[n - 1] = d - cum[n - 1];
  for (long long int i = (n - 2); i >= (0); i--)
    maxi[i] = min(maxi[i + 1], d - cum[i]);
  for (long long int i = (0); i < (n); i++) {
    cum[i] = 0;
    cum[i] = cum[max(0ll, i - 1)] + arr[i];
    if (arr[i] == 0 && cum[i] < 0) {
      if ((maxi[i] - sum) < 0) return 0 * printf("%s\n", "-1");
      cum[i] += (maxi[i] - sum);
      sum = maxi[i];
      cnt++;
      if (cum[i] < 0) return 0 * printf("%s\n", "-1");
    }
    if (cum[i] > d) return 0 * printf("%s\n", "-1");
  }
  printf("%lld\n", cnt);
  return 0;
}
