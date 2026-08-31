#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  cout << (c * (a - b) + b - 1) / b << endl;
  return 0;
}
