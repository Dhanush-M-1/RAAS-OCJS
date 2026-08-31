#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  if (ceil(n * (y / 100) - x) <= 0) {
    cout << 0 << endl;
  } else {
    cout << ceil(n * (y / 100) - x) << endl;
  }
}
