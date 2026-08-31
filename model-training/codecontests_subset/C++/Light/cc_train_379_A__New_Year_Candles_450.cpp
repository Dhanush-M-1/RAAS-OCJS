#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, s, k;
  cin >> a >> b;
  s = a;
  while (1) {
    c = a / b;
    a = c + (a % b);
    s += c;
    if (a < b) break;
  }
  cout << s;
}
