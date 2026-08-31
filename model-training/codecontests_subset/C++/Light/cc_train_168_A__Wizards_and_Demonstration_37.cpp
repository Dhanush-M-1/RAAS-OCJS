#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x;
  double y;
  cin >> n >> x >> y;
  if ((x * 100) / n >= y) {
    cout << 0;
    exit(0);
  }
  cout << ceil((y * n) / 100 - x);
}
