#include <bits/stdc++.h>
using namespace std;
long long j, k, s, l, m, n, t, d;
long long e[111][33333], a, b, i, p, c;
map<string, long long> y;
string q, r, w;
int main() {
  cin >> n >> a >> b >> c;
  n *= 2;
  for (i = 0; i <= a; i++) {
    for (j = 0; j <= b; j++) {
      k = n - i - 2 * j;
      if (k % 4 == 0 && k / 4 <= c && k >= 0) s++;
    }
  }
  cout << s;
  return 0;
}
