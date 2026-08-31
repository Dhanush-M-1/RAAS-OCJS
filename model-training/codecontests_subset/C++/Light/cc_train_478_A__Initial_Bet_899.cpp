#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[5];
  int sum = 0;
  for (int i = 0; i < 5; i++) {
    cin >> a[i];
    sum += a[i];
  }
  if (sum == 0) {
    cout << -1;
    return 0;
  }
  if (sum % 5 == 0)
    cout << sum / 5;
  else
    cout << -1;
  return 0;
}
