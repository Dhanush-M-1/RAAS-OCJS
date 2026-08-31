#include <bits/stdc++.h>
using namespace std;
int main() {
  float n, x, y;
  cin >> n >> x >> y;
  float ans = (n / 100) * y;
  ans = ceil(ans);
  if (ans <= x)
    cout << "0" << endl;
  else {
    ans = ans - x;
    cout << ans << endl;
  }
}
