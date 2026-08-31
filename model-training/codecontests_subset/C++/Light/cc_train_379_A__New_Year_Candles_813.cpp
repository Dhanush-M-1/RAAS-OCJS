#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int sum = a;
  int x = a;
  while (x) {
    x = a / b;
    sum += x;
    a = x + (a % b);
  }
  cout << sum << endl;
  return 0;
}
