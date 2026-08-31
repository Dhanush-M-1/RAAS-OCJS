#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q;
  cin >> q;
  long long sqrtq = floor(sqrt(q)), cnt = 0, ps[2], k = 2;
  while (k <= sqrtq && cnt < 2 && q > 1)
    if (q % k == 0)
      ps[cnt++] = k, q /= k;
    else
      ++k;
  if (!cnt)
    cout << 1 << endl << 0 << endl;
  else if (q == 1 || cnt == 1)
    cout << 2 << endl;
  else
    cout << 1 << endl << ps[0] * ps[1] << endl;
  return 0;
}
