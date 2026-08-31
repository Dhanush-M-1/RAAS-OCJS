#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, pr, mx = 0, a;
  cin >> n >> c;
  cin >> a;
  pr = a;
  for (int i = 1; i < n; i++) {
    scanf("%d", &a);
    mx = max(mx, pr - a - c);
    pr = a;
  }
  cout << mx;
  return 0;
}
