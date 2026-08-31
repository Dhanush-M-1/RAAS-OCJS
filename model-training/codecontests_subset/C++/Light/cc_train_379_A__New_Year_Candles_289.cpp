#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  while (cin >> a >> b) {
    int left = a;
    while (left / b) {
      a += left / b;
      left = left - left / b * b + left / b;
    }
    cout << a << endl;
  }
  return 0;
}
