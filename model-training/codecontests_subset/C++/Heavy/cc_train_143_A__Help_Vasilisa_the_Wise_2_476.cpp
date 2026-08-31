#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, l, r1, r2, c1, c2, d1, d2, a, b, c, d;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool ch = false;
  for (i = 1; i <= 9; i++) {
    for (j = 1; j <= 9; j++) {
      for (k = 1; k <= 9; k++) {
        for (l = 1; l <= 9; l++) {
          a = i;
          b = j;
          c = k;
          d = l;
          set<int> st;
          st.insert(a);
          st.insert(b);
          st.insert(c);
          st.insert(d);
          if ((a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
               a + d == d1 && b + c == d2) &&
              st.size() == 4) {
            ch = true;
            break;
          }
        }
        if (ch) break;
      }
      if (ch) break;
    }
    if (ch) break;
  }
  if (ch) {
    cout << a << ' ' << b << endl;
    cout << c << ' ' << d << endl;
  } else
    cout << -1 << endl;
}
