#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int sum = a;
  while (a >= b) {
    int x = a / b;
    sum = sum + x;
    a = x + (a % b);
  }
  cout << sum << endl;
  return 0;
}
