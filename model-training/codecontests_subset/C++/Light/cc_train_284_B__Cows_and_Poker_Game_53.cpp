#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, i, F = 0, I = 0, A = 0;
  char c[200001];
  cin >> a;
  for (i = 1; i <= a; i++) {
    cin >> c[i];
    if (c[i] == 'I') {
      I++;
    } else if (c[i] == 'F') {
      F++;
    } else {
      A++;
    }
  }
  if (I == 1) {
    cout << 1;
  } else if (I > 1) {
    cout << 0;
  } else {
    cout << A;
  }
  return 0;
}
