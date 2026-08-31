#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, one = 0, two = 0, a[102];
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    ((a[i] / 100) & 1) ? one++ : two++;
  }
  if (((100 * one + 200 * two) / 100) & 1) {
    cout << "NO" << endl;
    return 0;
  }
  sort(a, a + n);
  int ans = (100 * one + 200 * two);
  for (int i = 0; i < n; i++) {
    ans -= a[i];
    for (int j = i + 1; j < n; j++) {
      if (2 * ans == (100 * one + 200 * two)) {
        cout << "YES" << endl;
        return 0;
      }
      ans -= a[j];
    }
    ans = (100 * one + 200 * two);
  }
  cout << "NO" << endl;
  return 0;
}
