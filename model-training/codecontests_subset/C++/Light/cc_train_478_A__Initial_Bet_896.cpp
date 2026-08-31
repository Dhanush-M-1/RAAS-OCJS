#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[5];
  int i, sum = 0;
  int count = 0;
  for (i = 0; i < 5; i++) {
    cin >> a[i];
    sum = sum + a[i];
  }
  int b = sum / 5;
  int c = sum % 5;
  if (sum == 0)
    cout << "-1";
  else if (sum != 0 && c == 0)
    cout << b;
  else
    cout << "-1";
}
