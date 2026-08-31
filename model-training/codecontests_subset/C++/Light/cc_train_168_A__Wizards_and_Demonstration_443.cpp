#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  double n, y;
  cin >> n >> x >> y;
  if (n * (y / 100) - x > 0) {
    cout << ceil(n * (y / 100) - x);
  } else {
    cout << 0;
  }
}
