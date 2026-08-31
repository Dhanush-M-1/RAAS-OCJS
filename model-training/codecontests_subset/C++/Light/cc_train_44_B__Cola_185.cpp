#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, count = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i = i + 2) {
    for (int j = 0; j <= b; j++) {
      if ((n - i / 2 - j) >= 0 && (n - i / 2 - j) % 2 == 0 &&
          (n - i / 2 - j) / 2 <= c)
        count++;
    }
  }
  cout << count;
  return 0;
}
