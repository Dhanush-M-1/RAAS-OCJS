#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long a, b = 0, c = 0, d = 0, e = 0;
    cin >> a;
    int arr[a];
    for (int i = 0; i < a; i++) {
      cin >> arr[i];
    }
    b = arr[0];
    for (int i = 0; i < a; i++) {
      if (i != 0) {
        if (arr[i] >= b) {
          c = arr[i];
          d = i;
          break;
        }
      }
    }
    for (int i = 0; i < a; i++) {
      if (i != d) {
        if (arr[i] >= (b + c)) {
          e = i;
          break;
        }
      }
    }
    if (e != 0) {
      cout << 1 << " " << d + 1 << " " << e + 1 << endl;
    } else {
      cout << -1 << endl;
    }
  }
}
