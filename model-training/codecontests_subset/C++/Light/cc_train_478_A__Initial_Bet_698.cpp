#include <bits/stdc++.h>
using namespace std;
int main() {
  int x = 0, a[5], sum = 0;
  for (int i = 0; i < 5; ++i) {
    cin >> a[i];
    sum += a[i];
    if (a[i] == 0) x++;
  }
  if (x == 5)
    cout << -1;
  else if (sum % 5 == 0) {
    cout << sum / 5;
  } else
    cout << -1;
  return 0;
}
