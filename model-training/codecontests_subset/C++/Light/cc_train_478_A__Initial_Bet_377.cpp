#include <bits/stdc++.h>
using namespace std;
int main() {
  int num, sum = 0;
  for (int i = 0; i < 5; ++i) {
    cin >> num;
    sum += num;
  }
  if (!(sum % 5) && sum > 0)
    cout << sum / 5 << endl;
  else
    cout << "-1" << endl;
  return 0;
}
