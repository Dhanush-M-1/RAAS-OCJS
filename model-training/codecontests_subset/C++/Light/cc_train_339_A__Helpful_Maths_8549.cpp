#include <bits/stdc++.h>
using namespace std;
int main() {
  string add;
  char temp;
  int i, len, sum, j;
  cin >> add;
  len = add.length();
  sum = (len - 1) / 2;
  for (i = 0; i < sum; i++) {
    for (j = 0; j < len - 2; j += 2) {
      if (add[j] > add[j + 2]) {
        temp = add[j];
        add[j] = add[j + 2];
        add[j + 2] = temp;
      }
    }
  }
  cout << add << endl;
  return 0;
}
