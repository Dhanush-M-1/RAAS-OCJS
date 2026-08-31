#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("no-stack-protector")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
using namespace std;
void seriy() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
signed main() {
  seriy();
  long long n;
  cin >> n;
  long long a;
  long long maxd = 0;
  for (long long i = 0; i < n; i++) {
    cin >> a;
    maxd = max(maxd, min(a - 1, 1000000 - a));
  }
  cout << maxd;
  return 0;
}
