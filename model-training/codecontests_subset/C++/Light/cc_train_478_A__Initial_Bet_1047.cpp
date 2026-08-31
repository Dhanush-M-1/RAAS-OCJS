#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[10], sum = 0;
  for (int i = 0; i < 5; i++) {
    cin >> a[i];
    sum += a[i];
  }
  if (sum % 5 != 0 || sum == 0)
    cout << "-1";
  else if (sum != 0)
    cout << sum / 5;
}
