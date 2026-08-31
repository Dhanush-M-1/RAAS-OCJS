#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, i, sum = 0, h = 0, t = 0, c;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> k;
    if (k == 100)
      h++;
    else
      t++;
    sum += k;
  }
  if (h % 2 != 0) {
    cout << "NO";
    return 0;
  } else {
    sum = sum / 2;
    c = sum / 200;
    if (c > t) {
      sum = sum - t * 200;
      c = sum / 100;
      if (c <= h)
        cout << "YES";
      else
        cout << "NO";
    } else {
      if (h || sum % 200 == 0)
        cout << "YES";
      else
        cout << "NO";
    }
  }
}
