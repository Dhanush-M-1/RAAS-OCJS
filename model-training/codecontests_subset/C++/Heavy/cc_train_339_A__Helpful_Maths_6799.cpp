#include <bits/stdc++.h>
using namespace std;
int main() {
  int length;
  bool true_false;
  char S[100], aux, digits[4] = "123";
  cin >> S;
  length = strlen(S);
  for (int i = 0, x = 0, j; i < length; i += 2) {
    true_false = false;
    if (S[i] != digits[x]) {
      for (j = i + 2; j < length; j += 2) {
        if (S[i] != digits[x]) {
          if (S[j] == digits[x]) {
            aux = S[i];
            S[i] = S[j];
            S[j] = aux;
            i += 2;
          } else {
            if (j == length - 1) {
              true_false = true;
            }
          }
        } else {
          i += 2;
        }
      }
    }
    if (true_false) {
      x++;
      i -= 2;
    }
  }
  for (int i = 0, x = 0, j; i < length; i += 2) {
    if (S[i] != digits[x]) {
      x++;
      if (S[i] != digits[x]) {
        for (j = i + 2; j < length; j++) {
          if (S[j] == S[i]) {
            aux = S[j - 2];
            S[j - 2] = S[i];
            S[i] = aux;
            break;
          }
        }
      }
    }
  }
  cout << S << endl;
}
