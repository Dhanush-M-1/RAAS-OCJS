#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, i, j, t;
  char c;
  string s;
  cin >> k;
  for (i = 1; i < k; i++) {
    for (j = 1; j < k; j++) {
      if (j > 1) {
        cout << " ";
      }
      t = i * j;
      s = "";
      while (t > 0) {
        c = t % k + '0';
        s = c + s;
        t /= k;
      }
      cout << s;
    }
    cout << "\n";
  }
  return 0;
}
