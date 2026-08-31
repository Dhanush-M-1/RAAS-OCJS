#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, count = 0, ans = 0;
  cin >> a >> b;
  for (int i = 1; i <= a; i++) {
    count++;
    ans++;
    if (count == b) {
      count = 0;
      i--;
    }
  }
  cout << ans;
  return 0;
}
