#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  int num[100], ind = 0;
  while (cin >> c) {
    if (isdigit(c)) {
      int e = c - '0';
      num[ind++] = e;
    }
  }
  sort(num, num + ind);
  for (int i = 0; i < ind; i++) {
    cout << num[i];
    if (i < ind - 1) cout << '+';
  }
}
