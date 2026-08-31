#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int pre_x = 0, x = 0, a;
  for (int i = 0; i < 3; i++) {
    if (i) pre_x = x;
    x = 0;
    for (int j = 0; j < n - i; j++) {
      cin >> a;
      x = x xor a;
    }
    if (i) cout << (pre_x xor x) << endl;
  }
  return 0;
}
