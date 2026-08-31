#include <bits/stdc++.h>
using namespace std;
const long long int M = 1e9 + 7;
int main() {
  long long int a, b;
  cin >> a >> b;
  long long int ans = 0;
  while (a >= 1) {
    if (a >= b) {
      ans += b;
      a = a - b + 1;
    } else {
      ans += a;
      a = 0;
    }
  }
  cout << ans << endl;
  return 0;
}
