#include <bits/stdc++.h>
using namespace std;
int main(int argc, char **argv) {
  double n, x, y, p, c;
  cin >> n >> x >> y;
  c = x;
  while (true) {
    p = 100 * c / n;
    if (p >= y) break;
    c += 1;
  }
  cout << c - x << endl;
  return EXIT_SUCCESS;
}
