#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int bin_search(int l, int r) {
  while (l != r) {
    int now = (l + r) / 2;
    if ((x + now) * 100 / n < y)
      l = now + 1;
    else
      r = now;
  }
  return l;
}
int main() {
  cin >> n >> x >> y;
  cout << bin_search(0, n * 100);
}
