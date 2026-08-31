#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  int memory[100];
  fill(memory, memory + 100, 0);
  int index = 1;
  for (int ti = 0; ti < t; ti++) {
    string command;
    cin >> command;
    if (command == "alloc") {
      int size;
      cin >> size;
      int count = 0;
      int start = -1;
      for (int mi = 0; mi < m; mi++) {
        if (memory[mi] != 0) {
          count = 0;
          continue;
        }
        count++;
        if (count == size) {
          start = mi - size + 1;
          break;
        }
      }
      if (start != -1) {
        for (int si = 0; si < size; si++) memory[si + start] = index;
        cout << index++ << endl;
      } else {
        cout << "NULL" << endl;
      }
    } else if (command == "erase") {
      int x;
      cin >> x;
      bool found = false;
      for (int mi = 0; mi < m; mi++)
        if (memory[mi] == x) {
          memory[mi] = 0;
          found = true;
        }
      if (x == 0 || !found) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      int len = 0;
      for (int mi = 0; mi < m; mi++) {
        if (memory[mi] == 0)
          len++;
        else {
          for (int mj = mi; mj < m; mj++) memory[mj - len] = memory[mj];
          for (int mj = 0; mj < len; mj++) memory[m - mj - 1] = 0;
          mi -= len;
          len = 0;
        }
      }
    }
  }
  return 0;
}
