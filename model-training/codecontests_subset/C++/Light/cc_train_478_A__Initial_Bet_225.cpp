#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b = 0;
  for (int i = 1; i <= 5; i++) {
    cin >> a;
    b += a;
  }
  if (b % 5 != 0 || b == 0)
    cout << -1;
  else
    cout << b / 5;
}
