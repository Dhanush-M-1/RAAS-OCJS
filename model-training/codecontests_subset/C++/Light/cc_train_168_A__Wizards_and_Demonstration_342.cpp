#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int np = ceil(n * (y / 100.0));
  if (np <= x) {
    cout << 0 << endl;
    return 0;
  }
  cout << np - x << endl;
}
