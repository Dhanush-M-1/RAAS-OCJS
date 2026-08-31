#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, c1, c2, c3, c4, c5;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  if ((c1 + c2 + c3 + c4 + c5) % 5 == 0) {
    j = (c1 + c2 + c3 + c4 + c5) / 5;
    if (j == 0) {
      cout << "-1\n";
    } else {
      cout << j << endl;
    }
  } else {
    cout << "-1\n";
  }
  return 0;
}
