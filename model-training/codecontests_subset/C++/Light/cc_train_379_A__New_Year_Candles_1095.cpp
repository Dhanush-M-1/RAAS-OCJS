#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, un, u, t = 0;
  cin >> a >> b;
  t = a;
  u = a;
  un = 0;
  do {
    un = u / b;
    t = t + un;
    u = u % b + un;
  } while (u > b);
  un = u / b;
  t = t + un;
  cout << t;
  return 0;
}
