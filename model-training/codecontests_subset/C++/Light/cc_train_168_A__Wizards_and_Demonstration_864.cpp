#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  long long per = n * y;
  if (((x * 100) / n) >= y) {
    cout << 0;
  } else {
    if (per % 100 == 0)
      per = per / 100;
    else
      per = per / 100 + 1;
    cout << abs(x - per);
  }
}
