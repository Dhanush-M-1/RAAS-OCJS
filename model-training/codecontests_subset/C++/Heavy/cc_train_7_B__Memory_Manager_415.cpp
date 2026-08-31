#include <bits/stdc++.h>
using namespace std;
int memory[100 + 5];
int main() {
  int t, m;
  int index = 1;
  cin >> t >> m;
  for (int i = 1; i <= m; i++) {
    memory[i] = 0;
  }
  for (int cnt = 1; cnt <= t; cnt++) {
    string s;
    int n;
    cin >> s;
    if (s[0] != 'd') {
      cin >> n;
    }
    if (s[0] == 'a') {
      bool allocatedok = false;
      for (int i = 1; i <= m; i++) {
        int tmp = 0;
        int final = m > i + n - 1 ? i + n - 1 : m;
        for (int j = i; j <= final; j++) {
          if (memory[j] == 0) {
            tmp++;
          }
        }
        if (tmp == n) {
          for (int j = i; j <= final; j++) {
            memory[j] = index;
          }
          index++;
          cout << index - 1 << endl;
          allocatedok = true;
          break;
        }
      }
      if (allocatedok == false) {
        cout << "NULL" << endl;
      }
    }
    if (s[0] == 'e') {
      bool eraseok = false;
      for (int i = 1; i <= m; i++) {
        if (memory[i] == n) {
          eraseok = true;
          break;
        }
      }
      if (n == 0) {
        eraseok = false;
      }
      if (eraseok == false) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      } else {
        for (int i = 1; i <= m; i++) {
          if (memory[i] == n) {
            memory[i] = 0;
          }
        }
      }
    }
    if (s[0] == 'd') {
      int tmpmemory[100 + 5];
      for (int i = 1; i <= m; i++) {
        tmpmemory[i] = 0;
      }
      int start = 1;
      for (int i = 1; i <= m; i++) {
        if (memory[i] != 0) {
          tmpmemory[start++] = memory[i];
        }
      }
      for (int i = start; i <= m; i++) {
        tmpmemory[i] = 0;
      }
      for (int i = 1; i <= m; i++) {
        memory[i] = tmpmemory[i];
      }
    }
  }
  return 0;
}
