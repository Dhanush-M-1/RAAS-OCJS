#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t > 0) {
    int a, b, c, stone = 0;
    cin >> a >> b >> c;
    while (b > 0) {
      if (c >= 2) {
        stone = stone + 3;
        c = c - 2;
        b--;
      } else if (a >= 1 && b >= 2) {
        a--;
        b = b - 2;
        stone = stone + 3;
      } else
        break;
    }
    cout << stone << endl;
    t--;
  }
}
