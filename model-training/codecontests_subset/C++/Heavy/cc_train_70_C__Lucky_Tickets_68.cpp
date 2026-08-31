#include <bits/stdc++.h>
using namespace std;
long long maxx, maxy, w, sum;
map<long double, long long> mp, Mp;
inline long long rev(long long x) {
  long long sum = 0;
  while (x) {
    sum = sum * 10 + x % 10;
    x /= 10;
  }
  return sum;
}
int main() {
  cin >> maxx >> maxy >> w;
  for (long long i = 1; i <= maxx; i++) mp[i * 1.0 / rev(i)]++;
  for (long long i = 1; i <= maxy; i++) sum += mp[rev(i) * 1.0 / i];
  if (sum < w) {
    printf("-1\n");
    return 0;
  }
  long long ansx = maxx, ansy = maxy, X = maxx, Y = 1;
  sum = mp[1];
  Mp[1]++;
  while (X >= 1 && Y <= maxy) {
    if (sum >= w) {
      if (X * Y < ansx * ansy) {
        ansx = X;
        ansy = Y;
      }
      long double x = X * 1.0 / rev(X);
      sum -= Mp[x];
      mp[x]--;
      X--;
    } else {
      Y++;
      long double x = rev(Y) * 1.0 / Y;
      sum += mp[x];
      Mp[x]++;
    }
  }
  printf("%lld %lld\n", ansx, ansy);
  return 0;
}
