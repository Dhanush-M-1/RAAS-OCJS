#include <bits/stdc++.h>
using namespace std;
string ko(int k, int y) {
  string g = "";
  while (y > 0) {
    g = char(y % k + 48) + g;
    y = y / k;
  }
  return g;
}
int main() {
  int k;
  cin >> k;
  int i, j;
  for (i = 1; i <= k - 1; i++) {
    for (j = 1; j <= k - 1; j++) {
      cout << ko(k, i * j) << " ";
    }
    cout << endl;
  }
}
