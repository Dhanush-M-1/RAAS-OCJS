#include <bits/stdc++.h>
using namespace std;
int main() {
  int K;
  cin >> K;
  while (K--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    if (c / 2 <= b) {
      ans += (c / 2) * 3;
      b -= ans / 3;
    } else {
      ans += b * 3;
      b = 0;
    }
    if (b / 2 <= a) {
      ans += (b / 2) * 3;
    } else
      ans += a * 3;
    cout << ans << "\n";
  }
  return 0;
}
