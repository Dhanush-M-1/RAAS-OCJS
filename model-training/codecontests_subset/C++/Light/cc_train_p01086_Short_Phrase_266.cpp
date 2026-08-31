#include <bits/stdc++.h>
using namespace std;

using VI = vector<long>;

long TMP[5] = {5, 7, 5, 7, 7};

int main() {
  int n;
  while (1) {
    cin >> n;
    if (n) {
      VI ps;
      for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        ps.push_back(s.size());
      }
      for (int first = 0; first < n; first++) {
        int diff = 0;
        bool legal = true;
        for (int k = 0; k < 5; k++) {
          int acc = 0;
          while (acc < TMP[k]) {
            acc += ps[first + diff];
            diff++;
          }
          if (acc > TMP[k]) {
            legal = false;
            break;
          }
        }
        if (legal) {
          cout << first+1 << endl;
          break;
        }
      }
    } else {
      return 0;
    }
  }
}

