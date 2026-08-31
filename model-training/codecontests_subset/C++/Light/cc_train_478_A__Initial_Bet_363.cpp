#include <bits/stdc++.h>
using namespace std;
int main() {
  int ans = 0, c;
  for (int i = 1; i <= 5; i++) {
    cin >> c;
    ans += c;
  }
  if (ans == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (ans % 5 == 0) {
    cout << ans / 5 << endl;
  } else {
    cout << -1 << endl;
  }
  return 0;
}
