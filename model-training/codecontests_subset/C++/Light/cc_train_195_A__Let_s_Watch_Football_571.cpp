#include <bits/stdc++.h>
using namespace std;
int main() {
  float a, b, c;
  cin >> a >> b >> c;
  cout << ceil((a * c - b * c) / b);
  return 0;
}
