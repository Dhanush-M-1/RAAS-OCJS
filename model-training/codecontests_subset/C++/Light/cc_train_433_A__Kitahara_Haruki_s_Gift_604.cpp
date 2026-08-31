#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100];
  cin >> n;
  int i, sum = 0, odd = 0, even = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    a[i] = a[i] / 100;
    if (a[i] == 1)
      odd++;
    else
      even++;
    sum += a[i];
  }
  if (sum % 2 == 1)
    cout << "NO" << endl;
  else if (odd % 2 == 0 && even % 2 == 0)
    cout << "YES" << endl;
  else if (odd == 0)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
