#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j;
  string b;
  cin >> b;
  j = b.size();
  sort(b.begin(), b.end());
  i = (b.size() - 1) / 2;
  b = b.substr(i, j);
  for (int x = 0, j = 0; j < ((2 * i) + 1); j++) {
    if (j % 2 == 0) {
      cout << b[x];
      x++;
    } else
      cout << "+";
  }
  return 0;
}
