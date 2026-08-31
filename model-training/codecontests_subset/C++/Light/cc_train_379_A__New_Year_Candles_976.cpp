#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int x = a;
  long int sum = 0;
  int res = 0;
  sum = a - (a % b);
  res = a % b + (a / b);
  while (res >= b) {
    sum += res - (res % b);
    res = res / b + res % b;
  }
  sum += res;
  cout << sum;
  return 0;
}
