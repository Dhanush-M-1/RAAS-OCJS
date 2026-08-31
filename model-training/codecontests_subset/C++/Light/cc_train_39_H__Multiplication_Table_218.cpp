#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      if ((i * j) / k != 0) cout << i * j / k;
      cout << (i * j) % k << " ";
    }
    cout << endl;
  }
  return 0;
}
