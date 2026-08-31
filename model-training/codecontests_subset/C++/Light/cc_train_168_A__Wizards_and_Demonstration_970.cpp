#include <bits/stdc++.h>
using namespace std;
int main() {
  int atleast, required;
  int n, x, y;
  cin >> n >> x >> y;
  if (x > (n * y) / 100)
    required = 0;
  else {
    required = (n * y) / 100 - x;
    if (((n * y) % 100) > 0) required++;
  }
  cout << required;
}
