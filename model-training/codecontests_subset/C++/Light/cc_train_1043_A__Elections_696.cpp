#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  int sum = 0, mx = 0;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    sum += a;
    mx = max(mx, a);
  }
  while (mx * n - sum <= sum) {
    mx++;
  }
  cout << mx << "\n";
}
