#include <bits/stdc++.h>
using namespace std;
int mem[128];
int main() {
  memset(mem, -1, sizeof(mem));
  int T, M;
  cin >> T >> M;
  int id = 0;
  for (int ct = 0; ct < (int)(T); ++ct) {
    string command;
    cin >> command;
    if (command[0] == 'd') {
      vector<int> v;
      for (int i = 0; i < (int)(M); ++i)
        if (mem[i] != -1) v.push_back(mem[i]);
      memset(mem, -1, sizeof(mem));
      for (int i = 0; i < (int)(v.size()); ++i) mem[i] = v[i];
    } else {
      int x;
      cin >> x;
      bool ok;
      if (command[0] == 'a') {
        for (int start = 0; start < (int)(M); ++start) {
          int size = 0;
          ok = false;
          for (int i = start; i < M; ++i) {
            if (mem[i] == -1) {
              size++;
              if (size == x) {
                ok = true;
                break;
              }
            } else
              break;
          }
          if (ok) {
            cout << ++id << endl;
            for (int i = start; i < start + size; ++i) mem[i] = id;
            break;
          }
        }
        if (!ok) cout << "NULL" << endl;
      } else if (command[0] == 'e') {
        int op = 0;
        for (int i = 0; i < (int)(M); ++i)
          if (x > 0 && mem[i] == x) {
            mem[i] = -1;
            ++op;
          }
        if (op == 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    }
  }
}
