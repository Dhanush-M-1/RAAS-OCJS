#include <bits/stdc++.h>
using namespace std;
long long gcd(long long x, long long y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}
int main() {
  long long mon[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  string s, ans;
  cin >> s;
  long long ma = 0;
  for (long long i = 2013; i < 2016; i++) {
    for (long long j = 1; j < 13; j++) {
      for (long long k = 1; k <= mon[j - 1]; k++) {
        long long c = 0;
        string t;
        if (k < 10) t = "0";
        t = t + to_string(k) + "-";
        if (j < 10) t = t + "0";
        t = t + to_string(j) + "-";
        t = t + to_string(i);
        size_t f = 0;
        while ((f = s.find(t, f)) != -1) {
          c++;
          f++;
        }
        if (c > ma) {
          ma = c;
          ans = t;
        }
      }
    }
  }
  cout << ans;
  return 0;
}
