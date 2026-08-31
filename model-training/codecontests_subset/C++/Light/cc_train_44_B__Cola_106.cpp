#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.precision(20);
  long long int n, a, b, c, d = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= c; i++) {
    for (int j = 0; j <= b; j++) {
      long long int x = 2 * n - 4 * i - 2 * j;
      if (a == 0) {
        if (x == 0) d++;
      } else {
        if (x >= 0 && x <= a) d++;
      }
      if (x < 0) break;
    }
  }
  cout << d;
}
