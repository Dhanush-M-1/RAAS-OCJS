#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  float t = 0.0;
  t = (a * c) - (b * c);
  cout << ceil(t / b);
}
