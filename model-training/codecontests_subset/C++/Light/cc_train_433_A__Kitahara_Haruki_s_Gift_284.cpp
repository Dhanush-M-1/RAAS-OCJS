#include <bits/stdc++.h>
using namespace std;
int a[10010];
int main() {
  int n, suma = 0, sumb = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x == 100) suma++;
    if (x == 200) sumb++;
  }
  if (suma == 0 || sumb == 0) {
    if (suma == 0 && sumb % 2 == 0) {
      cout << "YES";
      return 0;
    }
    if (suma % 2 == 0 && sumb == 0) {
      cout << "YES";
      return 0;
    }
    cout << "NO";
    return 0;
  }
  if (suma % 2 == 0 && sumb % 2 == 1) {
    cout << "YES";
    return 0;
  }
  if (suma % 2 == 0 && sumb % 2 == 0) {
    cout << "YES";
    return 0;
  }
  cout << "NO";
}
