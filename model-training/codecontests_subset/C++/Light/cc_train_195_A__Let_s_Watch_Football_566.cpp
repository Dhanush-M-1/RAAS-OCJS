#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int sum = c * a;
  int p = 0;
  while (1) {
    if (p * b + c * b >= sum) {
      cout << p;
      break;
    }
    p++;
  }
  return 0;
}
