#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, z, count = 0, a[100000];
  for (y = 0; y < 5; y++) {
    cin >> a[y];
    count = count + a[y];
  }
  if (count % 5 == 0 && count != 0) {
    cout << count / 5;
  } else
    cout << "-1";
  return 0;
}
