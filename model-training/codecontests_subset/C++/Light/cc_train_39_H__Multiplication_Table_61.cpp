#include <bits/stdc++.h>
using namespace std;
void tabdil(int a, int b) {
  if (a < b)
    cout << a;
  else {
    cout << int(a / b);
    cout << a % b;
  }
  return;
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      tabdil(i * j, k);
      if (j != k - 1) cout << " ";
    }
    cout << endl;
  }
  return 0;
}
