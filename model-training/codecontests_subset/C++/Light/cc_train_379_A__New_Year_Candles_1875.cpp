#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = 0;
  int check = 0;
  while (a > 0) {
    ++ans;
    a--;
    ++check;
    if (check == b) {
      ++a;
      check = 0;
    }
  }
  cout << ans;
  return 0;
}
