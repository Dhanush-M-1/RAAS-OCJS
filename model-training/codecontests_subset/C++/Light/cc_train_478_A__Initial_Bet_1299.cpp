#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int c[5];
  long long int i, ans = 0;
  cin >> c[0] >> c[1] >> c[2] >> c[3] >> c[4];
  int sum = c[0] + c[1] + c[2] + c[3] + c[4];
  if (sum == 0)
    cout << "-1" << endl;
  else if (sum % 5 == 0)
    cout << sum / 5 << endl;
  else {
    cout << "-1" << endl;
  }
  return 0;
}
