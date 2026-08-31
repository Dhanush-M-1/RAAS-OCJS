#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  cin >> a >> b >> c;
  int ans = (a * c) / b - c;
  if ((a * c) % b != 0) ans++;
  cout << ans << endl;
  return 0;
}
