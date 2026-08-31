#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double percent = y / (100 * 1.00000);
  double current = x / (n * 1.00000);
  double pup = percent * n - x;
  if (percent < current) {
    cout << 0;
    return 0;
  }
  if (round(pup) < pup)
    cout << round(pup) + 1;
  else
    cout << round(pup);
}
