#include <bits/stdc++.h>
using namespace std;
int main() {
  int d, b, rasn = -100000;
  cin >> d >> b;
  vector<int> rin(d);
  for (int i = 0; i < d; ++i) {
    cin >> rin[i];
  }
  for (int i = 0; i < d - 1; ++i) {
    if (rin[i] - rin[i + 1] - b >= rasn) {
      rasn = rin[i] - rin[i + 1] - b;
    }
  }
  if (rasn < 0) {
    cout << 0;
    return 0;
  }
  cout << rasn;
  return 0;
}
