#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int div = a / b;
  int mod = a % b;
  int ans = 0, temp = 0;
  bool flag = false;
  while (div + mod >= b) {
    flag = true;
    ans += div;
    temp = mod;
    mod = (div + mod) % b;
    div = (div + temp) / b;
  }
  ans += div;
  if (flag == true)
    cout << ans + a;
  else
    cout << div + a;
  return 0;
}
