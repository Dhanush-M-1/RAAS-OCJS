#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t, m, iden = 1;
  cin >> t >> m;
  vector<int> memory(m, 1e9);
  while (t--) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int x;
      cin >> x;
      bool done = false;
      for (int i = 0; i < m && !done; i++) {
        int cntr = 0;
        for (int j = i; j < m; j++) {
          if (memory[j] == 1e9)
            cntr++;
          else
            break;
        }
        if (cntr >= x) {
          cntr = 0;
          for (int j = i; j < m; j++) {
            if (cntr == x) break;
            memory[j] = iden;
            cntr++;
          }
          iden++;
          done = true;
          break;
        }
      }
      if (!done)
        cout << "NULL" << endl;
      else
        cout << iden - 1 << endl;
    } else if (s == "erase") {
      int x;
      cin >> x;
      bool found = false;
      for (int i = 0; i < m; i++) {
        if (memory[i] == x) {
          found = true;
          memory[i] = 1e9;
        }
      }
      if (!found) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else if (s == "defragment") {
      vector<int> temp;
      for (int i = 0; i < m; i++)
        if (memory[i] != 1e9) temp.push_back(memory[i]);
      for (int i = 0; i < m; i++) memory[i] = 1e9;
      for (int i = 0; i < temp.size(); i++) memory[i] = temp[i];
    }
  }
  return 0;
}
