#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int cc = 0;
  for (int i = 0; i <= a; i += 2)
    for (int j = 0; j <= b; j++) {
      if ((n - (i / 2) - j) % 2 == 0)
        if ((n - (i / 2) - j) <= c * 2)
          if ((n - (i / 2) - j) >= 0) cc++;
    }
  cout << cc << endl;
  return 0;
}
