#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int a, b, c;
    int cnt = 0;
    cin >> a >> b >> c;
    while (b && c > 1) {
      cnt += 3;
      b--;
      c -= 2;
    }
    while (a && b > 1) {
      cnt += 3;
      a--;
      b -= 2;
    }
    printf("%d", cnt);
    cout << "\n";
  }
  return 0;
}
