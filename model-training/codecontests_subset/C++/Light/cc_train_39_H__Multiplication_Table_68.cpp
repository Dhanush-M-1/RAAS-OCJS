#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, p;
  cin >> k;
  for (i = 1; i < k; i++) {
    for (j = 1; j < k; j++) {
      p = i * j;
      if (p >= k)
        cout << p / k;
      else
        cout << ' ';
      cout << p % k << ' ';
    }
    cout << endl;
  }
  return 0;
}
