#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = a;
  while (a >= b) {
    a -= b;
    a++;
    ans++;
  }
  cout << ans;
  return 0;
}
