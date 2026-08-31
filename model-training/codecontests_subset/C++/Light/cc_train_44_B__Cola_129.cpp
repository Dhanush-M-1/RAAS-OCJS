#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, res = 0, remain;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2) {
    if (i / 2 > n) break;
    for (int j = 0; j <= b; j++) {
      remain = n - (i / 2);
      if (remain < j) continue;
      remain -= j;
      if (remain % 2 != 0) continue;
      if (remain / 2 > c) continue;
      res++;
    }
  }
  cout << res << endl;
  return 0;
}
