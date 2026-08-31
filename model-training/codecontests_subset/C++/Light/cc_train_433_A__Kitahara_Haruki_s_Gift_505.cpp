#include <bits/stdc++.h>
using namespace std;
inline void boost() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
}
int n, h, th;
int main() {
  boost();
  cin >> n;
  for (int i = 1, x; i <= n; i++) {
    cin >> x;
    if (x == 100)
      h++;
    else
      th++;
  }
  if (th % 2 && h == 0)
    cout << "NO";
  else if ((th % 2 && h % 2) || (!(th % 2) && h % 2))
    cout << "NO";
  else
    cout << "YES";
  return 0;
}
