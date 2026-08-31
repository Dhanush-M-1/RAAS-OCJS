#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], o = 0, t = 0, sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100)
      o++;
    else
      t++;
    sum += a[i];
  }
  if (n == 1) {
    cout << "NO";
    return 0;
  }
  if ((sum / 100) % 2 != 0) {
    cout << "NO" << endl;
    return 0;
  }
  t = t % 2;
  if (t == 1) {
    t--;
    if (o >= 2) {
      o -= 2;
      if (o == 0) {
        cout << "YES" << endl;
        return 0;
      } else {
        if (o % 2 != 0) {
          cout << "NO" << endl;
          return 0;
        } else {
          cout << "YES" << endl;
          return 0;
        }
      }
    } else {
      cout << "NO" << endl;
      return 0;
    }
  } else {
    if (o % 2 == 0 && t == 0)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}
