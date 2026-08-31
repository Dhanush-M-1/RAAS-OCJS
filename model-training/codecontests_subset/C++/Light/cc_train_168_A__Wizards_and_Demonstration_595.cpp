#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y, cnt = 0;
  cin >> n >> x >> y;
  while (x / n < y / 100) {
    cnt++;
    x++;
  }
  cout << cnt << endl;
  return 0;
}
