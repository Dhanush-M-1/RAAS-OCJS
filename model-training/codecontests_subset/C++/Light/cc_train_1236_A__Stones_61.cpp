#include <bits/stdc++.h>
using namespace std;
int main() {
  long t;
  cin >> t;
  while (t--) {
    long a, b, c;
    cin >> a >> b >> c;
    long answer = 0;
    while (b >= 1 && c >= 2) {
      b -= 1;
      c -= 2;
      answer += 3;
    }
    while (a >= 1 && b >= 2) {
      a -= 1;
      b -= 2;
      answer += 3;
    }
    cout << answer << endl;
  }
}
