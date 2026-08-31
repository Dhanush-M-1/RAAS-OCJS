#include <bits/stdc++.h>
long long int mod = 1000000007;
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], i, sum = 0, z = 0, x = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    if (a[i] == 200) {
      z++;
    } else {
      x++;
    }
  }
  if (n == 1) {
    cout << "NO";
    return 0;
  }
  if ((sum / 2) % 100 == 0 && x != 0) {
    cout << "YES";
  } else if (x == 0 && n % 2 == 0) {
    cout << "YES";
  } else if (x == 0 && n % 2 != 0) {
    cout << "NO";
  } else {
    cout << "NO";
  }
}
