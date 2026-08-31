#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[100], b, c, i, sum = 0;
  for (i = 0; i < 5; i++) {
    cin >> a[i];
  }
  for (i = 0; i < 5; i++) {
    sum = sum + a[i];
  }
  if (sum % 5 == 0 && sum > 0) {
    sum = sum / 5;
    cout << sum;
  } else {
    cout << "-1";
  }
  return 0;
}
