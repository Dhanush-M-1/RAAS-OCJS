#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  if (ceil((n * y) / 100) <= x)
    cout << "0";
  else {
    cout << ceil((n * y) / 100) - x;
  }
}
