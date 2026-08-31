#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[100];
  cin >> a;
  int i, temp;
  int j = 0;
  while (a[j] != '\0') {
    i = 0;
    while (a[i] != '\0') {
      if (a[i + 1] != '\0') {
        if (a[i] > a[i + 2]) {
          temp = a[i];
          a[i] = a[i + 2];
          a[i + 2] = temp;
        }
      }
      i += 2;
    }
    j += 2;
  }
  cout << a;
  return 0;
}
