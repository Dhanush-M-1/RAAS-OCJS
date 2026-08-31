#include <bits/stdc++.h>
using namespace std;
int main(int argc, char* argv[]) {
  int n, a, b, c, nn, cnt = 0;
  int i, j, maxb, maxc;
  cin >> n >> a >> b >> c;
  maxc = min(c, n / 2);
  for (i = 0; i <= maxc; i++) {
    maxb = min(b, (n - i * 2));
    for (j = 0; j <= maxb; j++) {
      nn = i * 2 + j;
      if (((n - nn) * 2 <= a)) cnt++;
    }
  }
  cout << cnt << endl;
  return 0;
}
