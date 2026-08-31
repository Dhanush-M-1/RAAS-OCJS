#include <bits/stdc++.h>
using namespace std;
const int maxn = 1007;
int occupied[maxn];
int main() {
  int n, m;
  cin >> n >> m;
  int identifier = 0;
  for (int i = (0), _b = ((n)-1); i <= _b; i++) {
    string command;
    cin >> command;
    if (command == "alloc") {
      int request;
      cin >> request;
      int block = 0;
      for (int j = 1; j <= m; j += 1) {
        if (occupied[j])
          block = 0;
        else
          block++;
        if (block < request) continue;
        identifier++;
        while (request--) occupied[j - request] = identifier;
        break;
      }
      if (block < request)
        cout << "NULL" << endl;
      else
        cout << identifier << endl;
    } else if (command == "erase") {
      int request;
      cin >> request;
      if (request == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      }
      int ok = 0;
      for (int j = 1; j <= m; j += 1)
        if (occupied[j] == request) {
          occupied[j] = 0;
          ok = 1;
        }
      if (!ok || request > identifier) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      int start = 0;
      for (int j = 1; j <= m; j += 1)
        if (occupied[j]) occupied[++start] = occupied[j];
      while (++start <= m) occupied[start] = 0;
    }
  }
}
