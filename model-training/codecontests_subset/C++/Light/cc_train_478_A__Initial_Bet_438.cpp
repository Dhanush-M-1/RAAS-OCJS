#include <bits/stdc++.h>
using namespace std;
int main() {
  int ans = 0;
  for (int i = 1; i <= 5; i++) {
    int x;
    cin >> x;
    ans += x;
  }
  if (ans % 5 || ans == 0)
    cout << "-1\n";
  else
    cout << ans / 5 << endl;
  return 0;
}
