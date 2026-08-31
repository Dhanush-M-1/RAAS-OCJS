#include <bits/stdc++.h>
using namespace std;
const int kMaxN = 1000000;
int main() {
  int a, b;
  cin >> a >> b;
  int rez = 0;
  rez = a;
  while (a >= b) {
    int d = a / b;
    rez += d;
    a -= d * b;
    a += d;
  }
  cout << rez << '\n';
  return 0;
}
