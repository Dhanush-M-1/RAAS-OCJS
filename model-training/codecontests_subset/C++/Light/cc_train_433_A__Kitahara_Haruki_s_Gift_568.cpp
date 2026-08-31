#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n + 1];
  int sum = 0;
  int hun = 0;
  int twos = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == 100) {
      hun++;
    } else {
      twos++;
    }
    sum += a[i];
  }
  if ((sum / 2) % 100 != 0) {
    cout << "NO" << endl;
    return 0;
  }
  if (hun % 2 == 0 && hun != 0) {
    cout << "YES" << endl;
  } else if (hun == 0 && twos % 2 == 0) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
