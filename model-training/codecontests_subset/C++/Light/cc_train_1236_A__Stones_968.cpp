#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    int count = 0;
    while (b >= 1 && c >= 2) {
      b--;
      c -= 2;
      count++;
    }
    while (b >= 2 && a >= 1) {
      b -= 2;
      a--;
      count++;
    }
    cout << count * 3 << endl;
  }
}
