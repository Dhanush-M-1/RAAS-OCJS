#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, i, j, val, resto, pos;
  int resposta[10000];
  while (cin >> a) {
    pos = 0;
    for (i = 1; i < a; i++) {
      val = i;
      while (val) {
        resposta[pos] = val % a;
        pos++;
        val /= a;
      }
      while (pos > 0) {
        pos = pos - 1;
        cout << resposta[pos];
      }
      for (j = 2; j < a; j++) {
        val = i * j;
        while (val) {
          resposta[pos] = val % a;
          pos++;
          val /= a;
        }
        cout << " ";
        while (pos > 0) {
          pos = pos - 1;
          cout << resposta[pos];
        }
      }
      cout << endl;
    }
  }
  return 0;
}
