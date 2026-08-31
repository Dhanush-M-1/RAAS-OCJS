#include <bits/stdc++.h>
using namespace std;
int n, res, a, b, c;
int main() {
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i++)
    if (i % 2 == 0)
      for (int j = 0; j <= b; j++) {
        int s = i / 2 + j;
        if (s > n) continue;
        if ((n - s) % 2 == 0 && n - s <= c * 2) res++;
      }
  cout << res << endl;
  return 0;
}
