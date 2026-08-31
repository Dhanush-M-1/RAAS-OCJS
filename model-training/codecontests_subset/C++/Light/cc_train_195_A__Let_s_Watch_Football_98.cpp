#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  cout << (a * c - b * c) / b + (((a * c - b * c) % b) > 0) ? 1 : 0;
  return 0;
}
