#include <bits/stdc++.h>
using namespace std;
int main() {
  long long s1 = 0, s2 = 0, a;
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a;
    s1 += a;
  }
  s2 = s1;
  for (int i = 0; i < n - 1; ++i) {
    cin >> a;
    s1 -= a;
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> a;
    s2 -= a;
  }
  s2 -= s1;
  cout << s1 << endl << s2;
  return 0;
}
