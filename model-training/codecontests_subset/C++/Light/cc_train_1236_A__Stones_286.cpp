#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int a, b, c;
    cin >> a >> b >> c;
    int d = min(b, c / 2);
    b -= d;
    int e = min(a, b / 2);
    a -= e;
    cout << d * 3 + e * 3 << endl;
  }
}
