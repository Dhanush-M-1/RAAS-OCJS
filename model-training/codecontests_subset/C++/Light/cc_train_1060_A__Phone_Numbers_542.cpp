#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, k, c = 0;
  cin >> i;
  char a[100];
  for (k = 0; k < i; k++) {
    cin >> a[k];
  }
  for (k = 0; k < i; k++) {
    if (a[k] == '8') c++;
  }
  if (c >= i / 11) {
    cout << i / 11 << endl;
  } else if (c == 1 && i >= 11) {
    cout << 1 << endl;
  } else if (c == 2 && i >= 11) {
    cout << 2 << endl;
  } else if (c == 5 && i >= 11) {
    cout << 5 << endl;
  } else
    cout << 0 << endl;
  return 0;
}
