#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[10000] = {0};
  long b[10000] = {0};
  long t = 0, l;
  gets(a);
  l = strlen(a);
  for (int i = 0; i < l; i++) {
    if (isdigit(a[i])) {
      b[t] = a[i] - 48;
      t++;
    }
  }
  sort(b, b + t);
  cout << b[0];
  for (int j = 1; j < t; j++) {
    cout << "+" << b[j];
  }
  return 0;
}
