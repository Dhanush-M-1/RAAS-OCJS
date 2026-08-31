#include <bits/stdc++.h>
using namespace std;
int main() {
  long int a, b, m, n, i, j, k, l, cnt = 0, ans, Min;
  char c[113];
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> c[i];
    if (c[i] == '8') {
      cnt++;
    }
  }
  ans = n / 11;
  Min = min(ans, cnt);
  cout << Min << endl;
  return 0;
}
