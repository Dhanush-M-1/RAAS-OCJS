#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int a, b, c;
  cin >> a >> b >> c;
  int ret = a * c / b + ((a * c % b == 0) ? 0 : 1);
  cout << ret - c << endl;
  return 0;
}
