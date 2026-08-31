#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      if (i * j < k)
        cout << i * j << " ";
      else {
        int tmp = 0;
        int cnt = 0;
        int t = i * j;
        while (t > 0) {
          tmp += pow(10, cnt++) * (t % k);
          t /= k;
        }
        cout << tmp << " ";
      }
    }
    cout << "\n";
  }
}
