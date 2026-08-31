#include <bits/stdc++.h>
using namespace std;
int main() {
  int a1, a2, a3, a4, a5;
  cin >> a1 >> a2 >> a3 >> a4 >> a5;
  if ((a1 + a2 + a3 + a4 + a5) % 5 == 0 && (a1 + a2 + a3 + a4 + a5) != 0) {
    cout << (a1 + a2 + a3 + a4 + a5) / 5;
  } else {
    cout << -1;
  }
}
