#include <bits/stdc++.h>
using namespace std;
int main() {
  int c[5], i = 0, sum = 0;
  while (i < 5) {
    cin >> c[i];
    sum += c[i];
    i++;
  }
  if (sum % 5 == 0 && sum != 0)
    cout << sum / 5 << endl;
  else
    cout << -1 << endl;
  return 0;
}
