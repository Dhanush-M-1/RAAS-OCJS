#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  while (cin >> n >> k) {
    int r = 100000;
    for (int i = 0; i < n; i++) {
      int bucket;
      cin >> bucket;
      if (k % bucket == 0) {
        int temp = k / bucket;
        if (temp < r) {
          r = temp;
        }
      }
    }
    cout << r << endl;
  }
  return 0;
}
