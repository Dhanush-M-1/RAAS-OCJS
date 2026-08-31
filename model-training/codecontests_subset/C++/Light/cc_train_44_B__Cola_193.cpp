#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, n;
  cin >> n >> a >> b >> c;
  int res = 0;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= c; j++) {
      if (j * 2 + i / 2 > n)
        break;
      else if (j * 2 + i / 2 + b >= n)
        res++;
    }
  }
  cout << res;
}
