#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, ans;
int main() {
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i++)
    for (int j = 0; j <= b; j++)
      if (2 * n - (i + 2 * j) >= 0)
        if (2 * n - (i + 2 * j) <= 4 * c)
          ans += ((2 * n - (i + 2 * j)) % 4 == 0);
  cout << ans;
}
