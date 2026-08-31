#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, sum = 0, hun = 0, two = 0, t;
  cin >> n;
  if (n == 1)
    cout << "NO";
  else {
    long long a[210];
    for (i = 0; i < n; i++) {
      cin >> a[i];
      if (a[i] == 100)
        hun++;
      else
        two++;
    }
    if (hun == 0) {
      if (two % 2 == 0)
        cout << "YES";
      else
        cout << "NO";
    } else {
      t = abs(hun - (2 * two));
      if (t % 2 == 0)
        cout << "YES";
      else
        cout << "NO";
    }
  }
}
