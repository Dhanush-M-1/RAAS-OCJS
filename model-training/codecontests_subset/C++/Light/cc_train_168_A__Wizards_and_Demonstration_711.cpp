#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  for (int i = 0;; i++)
    if ((x + i) * 100 >= y * n) {
      cout << i;
      return 0;
    }
  return 0;
}
