#include <bits/stdc++.h>
using namespace std;
int n, a, b, x[101], y[101], s;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a >> b;
    x[b]++;
    y[a]++;
  }
  for (int i = 1; i <= 100; i++) s = s + x[i] * y[i];
  cout << s;
  return 0;
}
