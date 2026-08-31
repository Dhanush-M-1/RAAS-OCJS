#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  int avg = (a + b + c + d + e) / 5;
  if ((a + b + c + d + e) % 5 != 0 || avg == 0)
    cout << -1 << endl;
  else
    cout << avg << endl;
}
