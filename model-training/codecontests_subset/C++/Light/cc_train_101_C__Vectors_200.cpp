#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
int main() {
  long long a, b, c, d, x, y;
  cin >> a >> b >> x >> y >> c >> d;
  string ret = "NO";
  for (int i = 0; i < 4; ++i) {
    long long xx = x - a;
    long long yy = y - b;
    if (xx == 0 && yy == 0)
      ret = "YES";
    else if (c || d) {
      long long cc = -d;
      long long dd = c;
      long long dlt = c * dd - d * cc;
      long long dlt1 = xx * dd - yy * cc;
      long long dlt2 = c * yy - d * xx;
      if ((dlt1 % dlt) == 0 && (dlt2 % dlt) == 0) ret = "YES";
    }
    swap(a, b);
    a = -a;
  }
  cout << ret << endl;
  return 0;
}
