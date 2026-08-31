#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int s = 0, maxa = 0;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    s += a;
    maxa = max(maxa, a);
  }
  cout << max(maxa, 2 * s / n + 1);
}
