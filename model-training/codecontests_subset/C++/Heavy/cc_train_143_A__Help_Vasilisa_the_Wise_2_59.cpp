#include <bits/stdc++.h>
using namespace std;
long long n, caseno, r1, r2, c1, c2, d1, d2;
long long a[200005];
void ResetAll() {}
void Input() {
  scanf("%lld%lld%lld%lld%lld%lld", &r1, &r2, &c1, &c2, &d1, &d2);
}
bool Ok(int a, int b, int c, int d) {
  if (a + b != r1) return 0;
  if (c + d != r2) return 0;
  if (a + c != c1) return 0;
  if (b + d != c2) return 0;
  if (a + d != d1) return 0;
  if (c + b != d2) return 0;
  set<int> st;
  st.insert(a);
  st.insert(b);
  st.insert(c);
  st.insert(d);
  if (st.size() == 4) return 1;
  return 0;
}
void Calculation() {
  int resa, resb, resc, resd;
  bool ok = 0;
  for (int a = 1; a <= 9; a++) {
    for (int b = 1; b <= 9; b++) {
      for (int c = 1; c <= 9; c++) {
        for (int d = 1; d <= 9; d++) {
          if (Ok(a, b, c, d)) {
            resa = a, resb = b, resc = c, resd = d;
            ok = 1;
            break;
          }
        }
      }
    }
  }
  if (ok) {
    printf("%d %d\n%d %d\n", resa, resb, resc, resd);
  } else {
    puts("-1");
  }
}
void Solve() {
  Input();
  Calculation();
  ResetAll();
}
int main() {
  int q;
  q = 1;
  caseno = 0;
  while (q--) {
    caseno++;
    Solve();
  }
  return 0;
}
