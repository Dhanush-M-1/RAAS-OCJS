#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int maxn = *max_element(a, a + n);
  int ans = 0;
  for (int i = 0; i < n; i++) ans += (maxn - a[i]);
  int sum = 0;
  for (int i = 0; i < n; i++) sum += a[i];
  while (ans <= sum) {
    ans = 0;
    for (int i = 0; i < n; i++) ans += (maxn - a[i]);
    if (ans > sum) break;
    maxn++;
  }
  cout << maxn << "\n";
  return 0;
}
