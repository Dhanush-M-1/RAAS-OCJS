#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
int main() {
  int i, j, k;
  int n, m;
  int a, b, c;
  cin >> n >> a >> b >> c;
  if (a / 2 + b + c * 2 < n) {
    cout << 0 << endl;
    return 0;
  }
  long long cou = 0;
  for (i = 0; i <= a; i += 2)
    for (j = 0; j <= b; j++) {
      k = n - (i / 2 + j);
      if (k < 0) continue;
      if (k % 2 == 0 && k <= c * 2) cou++;
    }
  cout << cou << endl;
  return 0;
}
