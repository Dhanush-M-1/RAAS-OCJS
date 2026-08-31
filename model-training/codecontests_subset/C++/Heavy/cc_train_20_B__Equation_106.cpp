#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, s, d;
  cin >> a >> s >> d;
  long long ans = s * s - 4 * a * d;
  if (!a) {
    double aa = -d;
    aa /= s;
    if (!s && d)
      cout << 0;
    else if (isinf(aa) || (!s && !d))
      cout << -1;
    else
      cout << 1 << endl << setprecision(9) << aa;
  } else if (ans < 0)
    cout << 0;
  else if (isinf(sqrt(ans)))
    cout << -1;
  else {
    double sq = sqrt(ans);
    double aa = (-s - sq) / (2 * a), aa2 = (-s + sq) / (2 * a);
    if (aa == aa2)
      cout << 1 << endl << setprecision(15) << aa;
    else
      cout << 2 << endl
           << setprecision(15) << min(aa, aa2) << endl
           << setprecision(15) << max(aa, aa2);
  }
  return 0;
}
