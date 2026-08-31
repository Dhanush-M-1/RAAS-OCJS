#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int sum = 0;
  for (int i = 0; i <= a; i = i + 2) {
    for (int j = 0; j <= b; j++) {
      int res = (i / 2) + (j);
      int diff = n - res;
      if (diff < 0) {
        break;
      }
      if (diff % 2 == 0 && diff / 2 <= c) {
        sum++;
      }
    }
  }
  cout << sum;
}
