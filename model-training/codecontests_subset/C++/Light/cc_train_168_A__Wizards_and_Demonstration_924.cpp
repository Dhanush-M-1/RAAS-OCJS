#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int people = n - x;
  int wizards = x;
  people *= 100;
  wizards *= 100;
  int needed = max(0, n * y - wizards);
  cout << (needed + 99) / 100 << endl;
  return 0;
}
