#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  while (T--) {
    int a, b, c;
    cin >> a >> b >> c;
    int x = min(b, c / 2);
    b -= x;
    int y = min(a, b / 2);
    cout << 3 * (x + y) << '\n';
  }
}
