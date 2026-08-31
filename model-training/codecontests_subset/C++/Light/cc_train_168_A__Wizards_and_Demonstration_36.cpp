#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  float p = x * 100 / n;
  int i = 0;
  while (p < y) {
    i++;
    x++;
    p = x * 100 / n;
  }
  cout << i << endl;
}
