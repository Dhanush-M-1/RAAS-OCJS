#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int sum = a;
  while (a > 0) {
    if (a - b >= 0) {
      sum++;
      a -= b;
      a++;
    } else
      break;
  }
  cout << sum;
}
