#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  cin >> n >> a >> b >> c;
  int cnt = 0;
  for (int i = 0; i <= c && 2 * i <= n; i++)
    for (int j = 0; j <= b && 2 * i + j <= n; j++) {
      int s = n - (2 * i + j);
      if (2 * s <= a) cnt++;
    }
  cout << cnt;
  return 0;
}
