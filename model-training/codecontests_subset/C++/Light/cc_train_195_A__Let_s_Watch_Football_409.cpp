#include <bits/stdc++.h>
using namespace std;
int a[1000];
int l[1000];
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    int d = a * c - b * c;
    if (d % b == 0)
      cout << d / b << endl;
    else
      cout << d / b + 1 << endl;
  }
  return 0;
}
