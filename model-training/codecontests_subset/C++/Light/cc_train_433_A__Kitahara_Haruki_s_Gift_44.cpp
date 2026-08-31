#include <bits/stdc++.h>
using namespace std;
int n, sad, devist;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (a == 100) {
      sad++;
    } else {
      devist++;
    }
  }
  if (devist % 2) {
    devist = 1;
    if (sad >= 2) {
      sad -= 2;
      if (sad % 2 == 0) {
        cout << "YES" << endl;
        return 0;
      }
    }
  } else {
    devist = 0;
    if (sad % 2 == 0) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
