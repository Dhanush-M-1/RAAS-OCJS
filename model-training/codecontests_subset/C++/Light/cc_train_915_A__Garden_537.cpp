#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, ans, a, j = INT_MAX;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (a <= k && k % a == 0) j = min(j, k / a);
  }
  cout << j;
}
