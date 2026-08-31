#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long x, s1 = 0, s2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    s1 += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    s2 += x;
  }
  cout << s1 - s2 << endl;
  s1 = 0;
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    s1 += x;
  }
  cout << s2 - s1 << endl;
  return 0;
}
