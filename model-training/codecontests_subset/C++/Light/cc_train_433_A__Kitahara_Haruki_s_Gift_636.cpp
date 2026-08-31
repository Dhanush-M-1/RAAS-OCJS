#include <bits/stdc++.h>
using namespace std;
int main() {
  int q(0), w(0), n, h(0), d;
  cin >> n;
  int a[n - 1];
  if (n == 1) {
    cout << "NO";
    return 0;
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    h += a[i];
  }
  h = h / 100;
  if (h % 2 != 0) {
    cout << "NO";
    return 0;
  }
  h = h / 2;
  d = h;
  for (int i = 0; i < n; i++) {
    if (a[i] == 200) {
      q += 2;
    } else {
      w++;
    }
  }
  for (int i = 0; i < 100; i++) {
    if (h - 2 >= 0 && q > 0) {
      h -= 2;
      q -= 2;
    } else if (h - 1 >= 0 && w > 0) {
      h -= 1;
      w -= 1;
    } else {
      cout << "NO";
      return 0;
    }
    if (h == 0) {
      if (q + w == d) {
        cout << "YES";
        return 0;
      } else {
        cout << "NO";
        return 0;
      }
    }
  }
  return 0;
}
