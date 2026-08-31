#include <bits/stdc++.h>
using namespace std;
int main() {
  int c[5], i, sum = 0, ans;
  for (i = 0; i < 5; i++) {
    cin >> c[i];
    sum += c[i];
  }
  if (sum % 5 == 0 && sum != 0)
    cout << sum / 5 << endl;
  else
    cout << -1 << endl;
  return 0;
}
