#include <bits/stdc++.h>
using namespace std;
void fl() {}
int main() {
  fl();
  int q, d, l, data = 0, wait = 0;
  cin >> q >> d >> l;
  for (int t = 1; t <= l; ++t) {
    data += d - q;
    while (data < 0) data += d, ++wait;
  }
  cout << wait;
  return 0;
}
