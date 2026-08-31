#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)3e5 + 10;
const int inf = (int)1e9 + 5;
const long long llinf = (long long)1e18 + 5;
int a[1060][1060];
string b[1009][1000];
int q, w, e, k, s, d, n, m, t;
string can(int x) {
  string r = "";
  while (x > 0) {
    r = char(x % k + '0') + r;
    x /= k;
  }
  return r;
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++)
    for (int j = 1; j < k; j++) a[i][j] = i * j;
  for (int i = 1; i < k; i++)
    for (int j = 1; j < k; j++) {
      q = a[i][j];
      b[i][j] = can(q);
    }
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      cout << b[i][j] << ' ';
    }
    cout << endl;
  }
  return 0;
}
