#include <bits/stdc++.h>
using namespace std;
int main() {
  char instr[51], outstr[51] = {}, ch;
  int n, i;
  cin >> instr;
  cin >> n;
  for (i = 0; i < strlen(instr); i++) {
    if (instr[i] < 97) instr[i] += 32;
  }
  for (i = 0; i < strlen(instr); i++) {
    ch = instr[i];
    if (int(ch) < (n + 97)) {
      outstr[i] = ch - 32;
    } else {
      outstr[i] = ch;
    }
  }
  cout << outstr;
}
