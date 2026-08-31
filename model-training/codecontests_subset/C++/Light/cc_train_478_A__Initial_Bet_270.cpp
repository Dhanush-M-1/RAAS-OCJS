#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 5;
  int b, sum = 0;
  while (a--) {
    cin >> b;
    sum = sum + b;
  }
  if (sum == 0)
    cout << "-1" << endl;
  else if (sum % 5 == 0)
    cout << sum / 5 << endl;
  else
    cout << "-1" << endl;
}
