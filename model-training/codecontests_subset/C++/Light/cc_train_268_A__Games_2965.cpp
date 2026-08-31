#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, p[1001], q[1111], sum = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> p[i] >> q[i];
  for (int j = 1; j <= n; j++)
    for (int i = 1; i <= n; i++) {
      if (p[i] == q[j] && i != j) sum++;
    }
  cout << sum;
  return 0;
}
