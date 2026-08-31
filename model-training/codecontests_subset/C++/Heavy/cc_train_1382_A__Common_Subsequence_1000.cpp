#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, l1, l2, result, element;
  cin >> t;
  for (int i = 0; i < t; i++) {
    int a[1000], b[1000];
    result = 0;
    cin >> l1 >> l2;
    for (int j = 0; j < l1; j++) {
      cin >> a[j];
    }
    for (int k = 0; k < l2; k++) {
      cin >> b[k];
    }
    for (int x = 0; x < l2; x++) {
      for (int m = 0; m < l1; m++) {
        if (a[m] == b[x]) {
          result = 1;
          element = a[m];
          break;
        }
      }
      if (result == 1) {
        break;
      }
    }
    if (result == 1) {
      cout << "YES" << endl;
      cout << "1"
           << " " << element << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
