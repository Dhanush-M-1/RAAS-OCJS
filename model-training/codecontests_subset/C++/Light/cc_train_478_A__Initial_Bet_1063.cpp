#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, tong = 0, bien;
  for (int i = 0; i < 5; i++) {
    cin >> bien;
    tong += bien;
  }
  if (tong % 5 == 0 && tong != 0)
    cout << tong / 5;
  else
    cout << -1;
}
