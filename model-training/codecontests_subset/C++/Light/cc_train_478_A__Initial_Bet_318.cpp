#include <bits/stdc++.h>
using namespace std;
int main() {
  int ar[5];
  for (int i = 0; i < 5; i++) {
    cin >> ar[i];
  }
  int sum = 0;
  for (int i = 0; i < 5; i++) {
    sum = sum + ar[i];
  }
  if (sum % 5 == 0 && sum != 0) {
    cout << sum / 5;
  } else {
    cout << "-1";
  }
}
