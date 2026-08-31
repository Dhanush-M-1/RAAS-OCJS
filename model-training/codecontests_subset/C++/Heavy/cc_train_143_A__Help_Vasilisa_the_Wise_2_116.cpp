#include <bits/stdc++.h>
using namespace std;
const double PI = 3.141592654;
long long gcd(long long a, long long b) { return !b ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return (a / gcd(a, b)) * b; }
long long fib(int n) {
  return (((1 / sqrt(5)) * (pow((1 + sqrt(5)) / 2, n)) -
           ((1 / sqrt(5)) * (pow((1 - sqrt(5)) / 2, n)))));
}
void fast() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL), cout.tie(NULL);
}
int main() {
  fast();
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i + j == r1 && i + k == c1 && i + l == d1 && j + k == d2 &&
              j + l == c2 && k + l == r2) {
            set<int> st;
            st.insert(i), st.insert(j), st.insert(k), st.insert(l);
            if (st.size() == 4) {
              cout << i << " " << j << "\n" << k << " " << l;
              return 0;
            }
          }
        }
      }
    }
  }
  cout << -1;
  return 0;
}
