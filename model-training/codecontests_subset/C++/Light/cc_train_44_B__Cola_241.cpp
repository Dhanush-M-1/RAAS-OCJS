#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, con = 0;
  cin >> n >> a >> b >> c;
  double res;
  for (int c1 = 0; c1 <= b; c1++)
    for (int c2 = 0; c2 <= c; c2++) {
      res = c1 * 1 + c2 * 2;
      if (res <= n)
        if (double(a) * 0.5 >= (n - res)) con++;
    }
  cout << con << endl;
  return 0;
}
