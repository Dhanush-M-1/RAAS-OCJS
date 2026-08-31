#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, c, sum = 0;
  for (i = 0; i < 5; i++) {
    cin >> c;
    sum += c;
  }
  if (sum % 5 || !sum)
    cout << -1;
  else
    cout << sum / 5;
  return 0;
}
