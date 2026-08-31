#include <bits/stdc++.h>
using namespace std;
void s() {
  int n;
  cin >> n;
  int a[n], c1 = 0, c2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100)
      c1++;
    else
      c2++;
  }
  int sum = c1 * 100 + c2 * 200;
  if (sum % 200 != 0)
    cout << "NO";
  else {
    int f = 0;
    for (int i = 0; i <= c2; i++) {
      if (200 * i <= sum / 2 && sum / 2 - 200 * i <= c1 * 100) f = 1;
    }
    if (f == 1)
      cout << "YES";
    else
      cout << "NO";
  }
}
int main() {
  long long int t;
  t = 1;
  while (t--) {
    s();
    cout << "\n";
  }
}
