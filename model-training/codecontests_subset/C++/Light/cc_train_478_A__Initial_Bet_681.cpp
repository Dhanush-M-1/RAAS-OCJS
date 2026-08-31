#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[5];
  int i;
  for (i = 0; i < 5; i++) {
    cin >> arr[i];
  }
  int sum = 0;
  for (i = 0; i < 5; i++) {
    sum = sum + arr[i];
  }
  if (sum % 5 == 0 && sum != 0) {
    cout << sum / 5;
  }
  if (sum == 0) cout << "-1";
  if (sum % 5 != 0) cout << "-1";
  return 0;
}
