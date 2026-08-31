#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  if (a <= b) {
    cout << 0 << endl;
    return 0;
  }
  int t0 = c * (a - b) / b;
  if ((c * (a - b)) % b != 0) t0++;
  cout << t0 << endl;
}
