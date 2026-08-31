#include <bits/stdc++.h>
using namespace std;
short a, b, Total, R;
int main() {
  cin >> a >> b;
  Total = a;
  while (a / b != 0) {
    Total += a / b;
    R = a % b;
    a = R + a / b;
  }
  cout << Total << endl;
  return 0;
}
