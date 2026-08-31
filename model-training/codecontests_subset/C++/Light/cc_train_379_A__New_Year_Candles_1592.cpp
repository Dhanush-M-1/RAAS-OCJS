#include <bits/stdc++.h>
using namespace std;
int main() {
  float a, b, flag, sum1 = 0, neew = 0;
  int sum = 0;
  cin >> a >> b;
  flag = a;
  while (flag > 0.1) {
    sum1 = sum1 + flag;
    flag = flag / b;
  }
  sum = sum1;
  cout << sum;
  return 0;
}
