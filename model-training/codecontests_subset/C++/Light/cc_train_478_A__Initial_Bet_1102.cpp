#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a[5], sum = 0;
  for (int i = 0; i < 5; i++) {
    cin >> a[i];
    sum += a[i];
  }
  if (sum == 0) {
    cout << -1;
  } else if (sum % 5 == 0) {
    cout << sum / 5;
  } else {
    cout << -1;
  }
}
