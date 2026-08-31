#include <bits/stdc++.h>
using namespace std;
int n, x, y, c;
int main() {
  cin >> n >> x >> y;
  c = (n * y) / 100;
  if ((n * y) % 100 > 0) c++;
  if (x < c)
    cout << c - x;
  else
    cout << 0;
}
