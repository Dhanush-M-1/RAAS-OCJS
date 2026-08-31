#include <bits/stdc++.h>
using namespace std;
int main() {
  int cnt = 0;
  long long p, d[2];
  cin >> p;
  for (long long i = 2; i * i <= p; ++i) {
    while (p % i == 0) {
      p /= i;
      d[cnt] = i;
      if (++cnt >= 2) goto out;
    }
  }
out:
  if (cnt == 0)
    cout << 1 << endl << 0 << endl;
  else if (p == 1 || cnt == 1)
    cout << 2 << endl;
  else
    cout << 1 << endl << d[0] * d[1] << endl;
  return 0;
}
