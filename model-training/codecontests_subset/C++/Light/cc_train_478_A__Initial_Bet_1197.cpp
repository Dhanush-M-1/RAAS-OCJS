#include <bits/stdc++.h>
using namespace std;
bool cek(int x) { return (0 <= x and x <= 100); }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  int tot = a + b + c + d + e;
  if (tot % 5 == 0 and tot != 0) {
    cout << tot / 5 << endl;
  } else
    cout << -1 << endl;
}
