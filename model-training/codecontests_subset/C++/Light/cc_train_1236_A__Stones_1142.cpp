#include <bits/stdc++.h>
using namespace std;
int a, b, c, t;
int main() {
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int maxim = 0;
    for (int i = 0; i <= a; ++i) {
      for (int j = 0; j <= b; ++j) {
        int aa = a, bb = b, cc = c, contor = 0;
        aa -= i;
        bb -= 2 * i;
        if (aa < 0 || bb < 0) continue;
        contor = i * 3;
        bb -= j;
        cc -= 2 * j;
        if (bb < 0 || cc < 0) continue;
        contor += j * 3;
        maxim = max(contor, maxim);
      }
    }
    cout << maxim << "\n";
  }
  return 0;
}
