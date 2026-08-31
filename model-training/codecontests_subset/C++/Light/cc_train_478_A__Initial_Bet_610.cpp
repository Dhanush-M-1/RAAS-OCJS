#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 5, sum = 0;
  while (n--) {
    int a;
    cin >> a;
    sum += a;
  }
  if (sum == 0) {
    cout << -1 << endl;
    return 0;
  }
  cout << (sum % 5 == 0 ? sum / 5 : -1) << endl;
}
