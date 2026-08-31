#include <bits/stdc++.h>
using namespace std;
int main() {
  long long i, j, n, a, b, c, summ = 0;
  cin >> n;
  cin >> a >> b >> c;
  for (i = 0; i <= n / 2 && i <= c; i++)
    for (j = 0; j <= n && j <= b; j++)
      if (2 * i + j <= n && (n - 2 * i - j) * 2 <= a) summ++;
  cout << summ;
  cin >> i;
  return 0;
}
