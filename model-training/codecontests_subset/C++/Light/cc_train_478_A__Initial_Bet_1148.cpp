#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, sum;
  sum = 0;
  cin >> k;
  sum += k;
  cin >> k;
  sum += k;
  cin >> k;
  sum += k;
  cin >> k;
  sum += k;
  cin >> k;
  sum += k;
  if (sum % 5 == 0 && sum != 0)
    cout << sum / 5 << endl;
  else
    cout << "-1" << endl;
  return 0;
}
