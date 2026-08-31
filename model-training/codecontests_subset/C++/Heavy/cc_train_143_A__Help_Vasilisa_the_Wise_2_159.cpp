#include <bits/stdc++.h>
bool ascending(int i, int j) { return (i < j); }
bool descending(int i, int j) { return (i > j); }
using namespace std;
int main() {
  int r1, r2, d1, d2, c1, c2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int(a) = (1); (a) < (10); (a)++)
    for (int(b) = (1); (b) < (10); (b)++)
      for (int(c) = (1); (c) < (10); (c)++)
        for (int(d) = (1); (d) < (10); (d)++) {
          set<int> st;
          st.insert(a);
          st.insert(b);
          st.insert(c);
          st.insert(d);
          if (st.size() != 4) continue;
          if (a + d == d1 && b + c == d2 && a + b == r1 && c + d == r2 &&
              a + c == c1 && b + d == c2) {
            cout << a << " " << b << endl;
            cout << c << " " << d << endl;
            return 0;
          }
        }
  cout << -1 << endl;
}
