#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, ans;
  cin >> a >> b >> c;
  ans = ((a - b) * c + b - 1) / b;
  cout << ans << endl;
  return 0;
}
