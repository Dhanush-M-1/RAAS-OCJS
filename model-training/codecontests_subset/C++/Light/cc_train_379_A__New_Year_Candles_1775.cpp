#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum = 0;
  cin >> a >> b;
  int temp = 0;
  while (a >= b) {
    temp = a % b;
    a -= temp;
    sum += a;
    a /= b;
    a += temp;
  }
  sum += a;
  cout << sum;
  return 0;
}
