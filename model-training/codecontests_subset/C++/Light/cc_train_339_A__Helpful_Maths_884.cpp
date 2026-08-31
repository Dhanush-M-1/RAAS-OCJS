#include <bits/stdc++.h>
using namespace std;
char t[110];
int main() {
  int i = 0;
  int temp;
  while (cin >> t[i]) {
    i++;
  }
  sort(t, t + i);
  for (int j = 0; j < i; j++) {
    if (j > 0) {
      if (t[j - 1] >= '1' && t[j - 1] <= '3') {
        cout << "+";
      }
    }
    if (t[j] >= '1' && t[j] <= '3') {
      cout << t[j];
    }
  }
  cout << endl;
  return 0;
}
