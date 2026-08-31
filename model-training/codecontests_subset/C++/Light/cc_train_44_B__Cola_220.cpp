#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  long long res = 0;
  cin >> n >> a >> b >> c;
  n *= 2;
  for (int ic = (0); ic <= (min(c, n / 4)); ++ic)
    for (int ib = (min(b, (n - 4 * ic) / 2)); ib >= (0); --ib)
      if (n - 4 * ic - 2 * ib <= a)
        res++;
      else
        break;
  cout << res << endl;
  return 0;
}
