#include <bits/stdc++.h>
using namespace std;
int i, j, k;
int main(void) {
  int n, tw, h;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> j;
    if (j == 100)
      h++;
    else
      tw++;
  }
  if (h == 0 && (tw % 2 != 0)) {
    cout << "NO";
    return 0;
  }
  if ((h + (2 * tw)) % 2 != 0) {
    cout << "NO";
  } else
    cout << "YES";
  return 0;
}
