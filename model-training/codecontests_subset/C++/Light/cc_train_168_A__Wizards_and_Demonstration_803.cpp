#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned int n, x, y;
  cin >> n >> x >> y;
  if (x * 100 >= y * n)
    cout << "0";
  else
    cout << ceil(y * n * 0.01) - x;
}
