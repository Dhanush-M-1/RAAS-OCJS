#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int t = ((a * c) + b - 1) / b;
  int h = t;
  while (h--) {
    if (t * b < (t - h) * a) break;
  }
  cout << h + 1;
  return 0;
}
