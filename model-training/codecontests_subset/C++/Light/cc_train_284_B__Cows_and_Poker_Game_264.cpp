#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int allin = 0;
  int in = 0;
  int folded = 0;
  unsigned char c;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c;
    if (c == 'A')
      allin++;
    else if (c == 'F')
      folded++;
    else
      in++;
  }
  if (allin == 0 && folded == 0) {
    cout << 0 << endl;
    return 0;
  }
  if (in == 1) {
    cout << 1 << endl;
    return 0;
  }
  if (in > 1) {
    cout << 0 << endl;
    return 0;
  }
  cout << n - folded << endl;
}
