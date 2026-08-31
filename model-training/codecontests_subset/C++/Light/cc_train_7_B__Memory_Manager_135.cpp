#include <bits/stdc++.h>
using namespace std;
int memory[300];
int main() {
  int t, m;
  cin >> t >> m;
  for (int i = 0; i < m; i++) memory[i] = -2;
  int last_id = 1;
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s[0] == 'a') {
      int n;
      cin >> n;
      int start = -1;
      for (int j = 0; j < m; j++) {
        int counts = 0;
        if (memory[j] == -2)
          for (int k = j; k < m; k++) {
            if (memory[k] != -2)
              break;
            else
              counts++;
          }
        if (counts >= n) {
          start = j;
          break;
        }
      }
      if (start == -1)
        cout << "NULL" << endl;
      else {
        for (int j = 0; j < n; j++) {
          memory[start] = last_id;
          start++;
        }
        cout << last_id << endl;
        last_id++;
      }
    } else if (s[0] == 'e') {
      int n;
      cin >> n;
      bool found = false;
      for (int i = 0; i < m; i++) {
        if (memory[i] == n) {
          found = true;
          memory[i] = -2;
        }
      }
      if (!found) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      for (int i = 0; i < m; i++) {
        if (i != m - 1 && memory[i] == -2 && memory[i + 1] != -2) {
          memory[i] = memory[i + 1];
          memory[i + 1] = -2;
          i = -1;
        }
      }
    }
  }
}
