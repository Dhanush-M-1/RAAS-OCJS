#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n *= 2;
  int cnt = 0;
  for (int i = 0; i <= a; i++)
    for (int j = 0; j <= b; j++) {
      int need = n - i - 2 * j;
      if (need >= 0 && need % 4 == 0 && need / 4 <= c) cnt++;
    }
  cout << cnt << "\n";
  return 0;
}
