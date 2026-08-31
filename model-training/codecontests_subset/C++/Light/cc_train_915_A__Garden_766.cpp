#include <bits/stdc++.h>
using namespace std;
int main() {
  int z, c, x[1000], q = 0;
  cin >> z >> c;
  for (int i = 0; i < z; i++) cin >> x[i];
  sort(x, x + z);
  for (int i = 0; i < z; i++) {
    if (c % x[i] == 0) {
      q = x[i];
    }
  }
  cout << c / q << endl;
  return 0;
}
