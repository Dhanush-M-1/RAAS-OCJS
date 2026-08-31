#include <bits/stdc++.h>
using namespace std;
int main() {
  int x[100];
  string a;
  int y = 0;
  cin >> a;
  for (size_t i = 0; i < a.length(); i++) {
    if (a[i] == '1') {
      x[y] = 1;
      y++;
    }
    if (a[i] == '2') {
      x[y] = 2;
      y++;
    }
    if (a[i] == '3') {
      x[y] = 3;
      y++;
    }
  }
  sort(x, x + y);
  for (size_t i = 0; i < y; i++) {
    if (i == y - 1) {
      cout << x[i];
      break;
    }
    cout << x[i] << "+";
  }
  cout << endl;
}
