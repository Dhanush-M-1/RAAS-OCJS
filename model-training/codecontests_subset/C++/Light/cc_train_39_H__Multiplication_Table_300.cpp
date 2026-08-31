#include <bits/stdc++.h>
using namespace std;
int table[15][15];
string turn(int x, int k) {
  int i;
  string s;
  char c;
  if (x < k) {
    c = x + '0';
    s += c;
    return s;
  } else {
    while (x > 0) {
      char c = (x % k) + '0';
      s = c + s;
      x = x / k;
    }
  }
  return s;
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      table[i][j] = table[i][j - 1] + i;
      cout << turn(table[i][j], k) << " ";
    }
    cout << endl;
  }
  return 0;
}
