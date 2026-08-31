#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, so;
  cin >> a >> b;
  long long int sum = a;
  so = a;
  for (; so >= b;) {
    sum += (so / b);
    so = (so / b) + (so % b);
  }
  cout << sum;
  return 0;
}
