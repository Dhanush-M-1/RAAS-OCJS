#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  y = y / 100;
  if (y <= x / n)
    cout << "0" << endl;
  else {
    cout << ceil(y * n - x) << endl;
  }
}
