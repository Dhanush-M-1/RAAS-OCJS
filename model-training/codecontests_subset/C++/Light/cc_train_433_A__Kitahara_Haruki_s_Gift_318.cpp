#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int N;
  cin >> N;
  int s = 0, a = 0, b = 0, x;
  for (int i = 0; i < int(N); i++) {
    cin >> x;
    s += x;
    if (x == 100)
      a++;
    else
      b++;
  }
  int i, j;
  bool f = false;
  for (i = 0; i <= a; i++) {
    for (j = 0; j <= b; j++) {
      if (100 * i + 200 * j == s / 2) f = true;
    }
  }
  if (!f)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
