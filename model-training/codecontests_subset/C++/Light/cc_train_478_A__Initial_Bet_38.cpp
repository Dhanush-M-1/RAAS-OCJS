#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0;
  for (int i = 0; i < 5; ++i) {
    int k;
    cin >> k;
    a += k;
  }
  if (a == 0)
    cout << -1 << endl;
  else if (a % 5 == 0)
    cout << a / 5 << endl;
  else
    cout << -1 << endl;
  return 0;
}
