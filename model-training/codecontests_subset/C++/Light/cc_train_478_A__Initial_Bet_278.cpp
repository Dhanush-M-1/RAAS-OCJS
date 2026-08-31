#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0;
  for (int i = 0; i < (int)5; i++) {
    int x;
    cin >> x;
    sum += x;
  }
  if (sum % 5 || sum == 0)
    cout << -1 << endl;
  else
    cout << sum / 5 << endl;
  return 0;
}
