#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int tab[n];
  int s = 0, x, m = -1;
  for (int i = 0; i < n; i++) {
    cin >> x;
    s += x;
    m = max(m, x);
  }
  int i = m, c = n * i - s;
  while (c <= s) {
    i++;
    c = n * i - s;
  }
  cout << i;
}
