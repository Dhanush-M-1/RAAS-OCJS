#include <bits/stdc++.h>
using namespace std;
int main() {
  char op[100], temp;
  cin >> op;
  if (strlen(op) == 1) {
    cout << op << endl;
    return 0;
  }
  for (int j = 0; j < strlen(op) - 2; j += 2) {
    for (int i = 0; i < strlen(op) - 2; i += 2) {
      if (op[i] > op[i + 2]) {
        temp = op[i];
        op[i] = op[i + 2];
        op[i + 2] = temp;
      }
    }
  }
  cout << op << endl;
  return 0;
}
