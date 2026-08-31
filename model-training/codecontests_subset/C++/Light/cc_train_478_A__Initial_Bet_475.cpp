#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[5];
  long res = 0, b;
  for (int i = 0; i < 5; i++) {
    cin >> arr[i];
    res += arr[i];
  }
  if (res % 5 == 0 && res != 0) {
    b = res / 5;
    cout << b;
  } else
    cout << -1;
  return 0;
}
