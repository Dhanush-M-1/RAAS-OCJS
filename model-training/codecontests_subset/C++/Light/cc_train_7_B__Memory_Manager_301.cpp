#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  vector<int> A;
  A.resize(m);
  int c = 0;
  for (int i = 0; i < m; ++i) A[i] = 0;
  for (int i = 0; i < t; ++i) {
    string z;
    int tmp;
    cin >> z;
    if (z[0] == 'd') {
      for (int j = 0; j < m - 1; ++j) {
        for (int k = m - 1; k > j; k--) {
          if (A[k] != 0 && 0 == A[k - 1]) {
            int tmp2 = A[k];
            A[k] = A[k - 1];
            A[k - 1] = tmp2;
          }
        }
      }
    } else if (z[0] == 'e') {
      cin >> tmp;
      int j = 0;
      while (j < m && A[j] != tmp) j++;
      if (j == m || tmp == 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      while (j < m && A[j] == tmp) {
        A[j] = 0;
        j++;
      }
    } else {
      cin >> tmp;
      int empty = 0;
      int j = 0;
      while (j < m && empty < tmp) {
        if (A[j] == 0)
          empty++;
        else
          empty = 0;
        j++;
      }
      if (j == m && empty < tmp)
        cout << "NULL" << endl;
      else {
        c++;
        for (int k = j - 1; k > j - 1 - empty; --k) {
          A[k] = c;
        }
        cout << c << endl;
      }
    }
  }
}
