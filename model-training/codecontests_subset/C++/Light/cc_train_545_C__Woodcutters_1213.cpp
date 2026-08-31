#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
long long x[N];
long long h[N];
int main() {
  int n;
  while (cin >> n) {
    for (int i = 0; i < n; i++) {
      cin >> x[i] >> h[i];
    }
    int ret = 0;
    int last = (long long)INT_MIN;
    for (int i = 0; i < n; i++) {
      if (x[i] - last > h[i]) {
        ret++;
        last = x[i];
      } else {
        if (i + 1 < n) {
          if (x[i] + h[i] < x[i + 1]) {
            ret++;
            last = x[i] + h[i];
          } else
            last = x[i];
        } else
          ret++;
      }
    }
    cout << ret << endl;
  }
  return 0;
}
