#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0;
  bool ne = 0;
  for (int i = 0; i < 5; i++) {
    int x;
    cin >> x;
    sum += x;
  }
  if (sum % 5 != 0 or sum == 0) {
    cout << "-1";
  } else
    cout << sum / 5;
  return 0;
}
