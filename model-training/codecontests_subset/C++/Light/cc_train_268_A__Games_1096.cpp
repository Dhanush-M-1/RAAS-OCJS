#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, h, a, hs[101], as[101], c = 0;
  cin >> n;
  for (i = 1; i <= 100; i++) {
    hs[i] = 0;
    as[i] = 0;
  }
  for (i = 1; i <= n; i++) {
    cin >> h >> a;
    hs[h]++;
    as[a]++;
  }
  for (i = 1; i <= 100; i++) {
    c = c + hs[i] * as[i];
  }
  cout << c;
}
