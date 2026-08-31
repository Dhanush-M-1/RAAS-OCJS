#include <bits/stdc++.h>
using namespace std;
long long const INF = (long long)1e9;
long long const INF64 = (long long)4e18;
long long const v10e5 = (long long)100000;
long long const v10e6 = (long long)1000000;
long long const v10e9 = (long long)1000000000;
long long const s10e5 = (long long)100000 + 10;
long long const s10e6 = (long long)1000000 + 10;
long long const s10e9 = (long long)1000000000 + 10;
long long __dummy__;
int main() {
  ios_base::sync_with_stdio(0);
  long long n;
  string s;
  cin >> n;
  cin >> s;
  long long a[3];
  a[0] = 0;
  a[1] = 0;
  a[2] = 0;
  for (long long(i) = (0); (i) <= (n - 1); ++i) {
    if (s[i] == 'A') {
      a[0]++;
    } else if (s[i] == 'I') {
      a[1]++;
    } else {
      a[2]++;
    }
  }
  long long ans = 0;
  for (long long(i) = (0); (i) <= (n - 1); ++i) {
    int shift = 0;
    if (s[i] == 'A' || s[i] == 'I') {
      if (s[i] == 'I') shift = 1;
      if (a[1] - shift == 0) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
