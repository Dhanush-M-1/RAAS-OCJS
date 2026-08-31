#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int ans = (a * c) / b;
  if ((a * c) % b) ans++;
  cout << ans - (c) << endl;
  return 0;
}
