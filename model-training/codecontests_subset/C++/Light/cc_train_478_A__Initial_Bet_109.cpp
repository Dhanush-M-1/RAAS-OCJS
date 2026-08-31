#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int x, y = 0;
  cin >> x;
  y += x;
  cin >> x;
  y += x;
  cin >> x;
  y += x;
  cin >> x;
  y += x;
  cin >> x;
  y += x;
  if (y % 5 || y == 0)
    cout << -1 << endl;
  else
    cout << y / 5 << endl;
  return 0;
}
