#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int a, b, count = 0;
  cin >> a >> b;
  int ans = a, rem = a;
  while (1) {
    a = ans / b;
    ans = (ans - a * b);
    ans += a;
    rem += a;
    if (a <= 0) break;
  }
  cout << rem << endl;
  return 0;
}
