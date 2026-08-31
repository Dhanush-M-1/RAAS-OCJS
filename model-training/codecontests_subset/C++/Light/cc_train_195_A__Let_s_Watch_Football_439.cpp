#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int m = ceil((a * c) / float(b));
  cout << m - c;
  return 0;
}
