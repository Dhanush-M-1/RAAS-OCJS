#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int r1, r2, c1, c2, d1, d2, w, x, y, z;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  w = (d1 + c1 - r2) / 2;
  x = r1 - w;
  y = c1 - w;
  z = r2 - y;
  set<int> s;
  s.insert(w);
  s.insert(x);
  s.insert(y);
  s.insert(z);
  if (s.size() != 4)
    cout << -1 << "\n";
  else if (w <= 0 || w > 9 || x <= 0 || x > 9 || y <= 0 || y > 9 || z <= 0 ||
           z > 9)
    cout << -1 << "\n";
  else {
    cout << w << " " << x << "\n";
    cout << y << " " << z << "\n";
  }
}
