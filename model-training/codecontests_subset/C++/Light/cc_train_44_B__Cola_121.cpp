#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, counter = 0, rem = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b; j++) {
      rem = n - (i / 2) - j;
      if (rem % 2 == 0 && rem <= (c * 2) && rem >= 0) {
        if (((i / 2) + j + (rem)) == n) {
          counter++;
        }
      }
    }
  }
  cout << counter << endl;
  return 0;
}
