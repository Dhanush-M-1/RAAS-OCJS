#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int v = ceil((n * y) / 100.0);
  if (x < v) {
    cout << (v - x);
  } else {
    cout << "0";
  }
  return 0;
}
