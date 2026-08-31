#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int min = k + 1;
  for (int i = 0; i < n; ++i) {
    int bucket;
    cin >> bucket;
    if (k % bucket == 0) {
      int times = k / bucket;
      if (min > times) {
        min = times;
      }
    }
  }
  cout << min << endl;
  return 0;
}
