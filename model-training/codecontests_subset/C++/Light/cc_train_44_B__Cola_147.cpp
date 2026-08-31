#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int k = 0;
  long double n, a, b, c, i, j, m;
  cin >> n >> a >> b >> c;
  for (i = 0; i <= a; i++) {
    for (j = 0; j <= c; j++) {
      m = n - (i / 2) - (2 * j);
      if (m >= 0 and m <= b and floor(m) == m) {
        k++;
      }
    }
  }
  cout << k;
}
