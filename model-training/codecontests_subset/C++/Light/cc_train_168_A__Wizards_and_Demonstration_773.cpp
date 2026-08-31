#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int ans = a * c / 100 + (a * c % 100 != 0);
  cout << (ans - b > 0 ? ans - b : 0);
  return 0;
}
