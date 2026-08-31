#include <bits/stdc++.h>
using namespace std;
string fun(int x, int b) {
  string a = "";
  while (x > 0) {
    char c = x % b + '0';
    a = c + a;
    x /= b;
  }
  return a;
}
int main() {
  int k;
  cin >> k;
  for (int i = 0; i < (k - 1); i++) {
    for (int j = 0; j < (k - 1); j++) {
      cout << fun((i + 1) * (j + 1), k) << " ";
    }
    cout << endl;
  }
  return 0;
}
