#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0;
  int cur;
  for (int i = 0; i < 5; ++i) {
    cin >> cur;
    sum += cur;
  }
  if (sum > 0 && sum % 5 == 0) {
    cout << sum / 5 << endl;
  } else {
    cout << -1 << endl;
  }
  return 0;
}
