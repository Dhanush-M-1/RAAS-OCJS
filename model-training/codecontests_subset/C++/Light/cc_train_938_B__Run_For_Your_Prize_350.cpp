#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  cin >> x;
  int t = 0, time;
  int onerange = 1;
  int large = 1000000;
  for (int i = 0; i < x; i++) {
    cin >> t;
    if (t > 500000) {
      if (t < large) {
        large = t;
      }
    } else {
      if (t > onerange) {
        onerange = t;
      }
    }
  }
  if ((onerange - 1) > (1000000 - large)) {
    cout << onerange - 1;
  } else {
    cout << 1000000 - large;
  }
  return 0;
}
