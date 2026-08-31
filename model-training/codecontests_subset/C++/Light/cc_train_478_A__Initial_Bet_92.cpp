#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0, ar[1000];
  for (int i = 0; i < 5; i++) cin >> ar[i];
  for (int i = 0; i < 5; i++) sum += ar[i];
  if (sum == 0)
    cout << "-1" << endl;
  else {
    if (sum % 5 == 0)
      cout << sum / 5 << endl;
    else
      cout << "-1" << endl;
  }
  return 0;
}
