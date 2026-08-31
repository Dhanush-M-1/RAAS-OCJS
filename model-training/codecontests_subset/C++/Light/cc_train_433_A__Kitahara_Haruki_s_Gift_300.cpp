#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> arr(n);
  int s = 0, d = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    s += arr[i];
  }
  d = s / 2;
  if (d % 100 != 0) {
    cout << "NO";
  } else {
    int c1 = 0, c2 = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 200)
        c2++;
      else
        c1++;
    }
    if (c2 != 0) {
      if (d / 200 >= c2) {
        c1 -= (d - 200 * c2) / 100;
        if (c1 < 0) {
          cout << "NO";
          return 0;
        }
        if (c1 * 100 != d)
          cout << "NO";
        else
          cout << "YES";
      } else {
        c2 -= d / 200;
        c1 -= (d - 200 * (d / 200)) / 100;
        if (c1 < 0) {
          cout << "NO";
          return 0;
        }
        if (c2 * 200 + c1 * 100 != d)
          cout << "NO";
        else
          cout << "YES";
      }
    } else {
      if (c1 / 2 * 100 != d)
        cout << "NO";
      else
        cout << "YES";
    }
  }
  return 0;
}
