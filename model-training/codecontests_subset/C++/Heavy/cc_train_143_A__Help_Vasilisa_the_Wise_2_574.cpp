#include <bits/stdc++.h>
using namespace std;
int main() {
  long c1, c2, r1, r2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  set<long> st;
  long t = 0;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i + k == c1 and j + l == c2 and i + j == r1 and k + l == r2 and
              i + l == d1 and j + k == d2 and (i != j and i != l and i != k)) {
            t = 1;
            st.insert(i);
            st.insert(j);
            st.insert(k);
            st.insert(l);
            if (st.size() == 4) {
              cout << i << " " << j << endl;
              cout << k << " " << l << endl;
              return 0;
            } else {
              cout << -1 << endl;
              return 0;
            }
          }
        }
      }
    }
  }
  if (t == 0) cout << -1 << endl;
  return 0;
}
