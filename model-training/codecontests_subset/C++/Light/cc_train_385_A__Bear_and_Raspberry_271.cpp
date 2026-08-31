#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int cnt = 0, sum = 0;
  for (int i = 0; i < n - 1; i++) {
    cnt = a[i] - a[i + 1] - k;
    sum = max(sum, cnt);
  }
  sum = max(sum, 0);
  cout << sum << endl;
}
