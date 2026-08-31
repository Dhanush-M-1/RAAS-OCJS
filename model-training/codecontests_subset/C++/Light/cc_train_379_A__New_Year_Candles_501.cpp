#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int count = a;
  int rest = 0;
  while (a >= b) {
    rest = a % b;
    a = (a / b);
    count += a;
    a += rest;
  }
  cout << count << endl;
  return 0;
}
