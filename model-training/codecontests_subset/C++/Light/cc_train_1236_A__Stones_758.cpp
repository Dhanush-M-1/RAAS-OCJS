#include <bits/stdc++.h>
using namespace std;
const int N = 1e6, NEG = -1e5, M = 4e5 + 9;
long long arr[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t, x, y, z;
  cin >> t;
  while (t--) {
    int counter = 0;
    cin >> x >> y >> z;
    if (y != 0) {
      if (z > 0) {
        (z / 2 > y) ? counter += y* 3 : counter += (z / 2) * 2 + z / 2;
        y -= z / 2;
      }
      if (y > 0 && x > 0) {
        (y / 2 > x) ? counter += x* 3 : counter += (y / 2) * 2 + y / 2;
      }
    }
    cout << counter;
    cout << "\n";
  }
}
