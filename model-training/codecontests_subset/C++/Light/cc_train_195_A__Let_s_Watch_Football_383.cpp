#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  for (int Ans = 0;; Ans++) {
    int have = b * Ans;
    int flag = 1;
    for (int k = 1; k <= c; k++) {
      have += b - a;
      if (have < 0) {
        flag = 0;
        break;
      }
    }
    if (flag == 1) {
      cout << Ans << endl;
      return 0;
    }
  }
  return 0;
}
