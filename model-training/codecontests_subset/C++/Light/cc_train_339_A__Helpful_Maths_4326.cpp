#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, len, counter;
  string a;
  char temp;
  while (cin >> a) {
    counter = 1;
    len = a.size();
    for (i = 0; i < len - 2; i += 2)
      for (j = 0; j < len - 2 - i; j += 2) {
        if (a[j] > a[j + 2]) {
          temp = a[j];
          a[j] = a[j + 2];
          a[j + 2] = temp;
        }
      }
    for (i = 0; i < len; i += 2) {
      if (counter > 1) cout << '+';
      counter++;
      cout << a[i];
    }
    cout << "\n";
  }
}
