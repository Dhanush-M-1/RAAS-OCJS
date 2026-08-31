#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, clone = 0;
  cin >> n >> x >> y;
  while (double((100 * (x + clone)) / n) < y) clone++;
  cout << clone;
}
