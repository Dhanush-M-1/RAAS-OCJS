#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  vector<int> b;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) b.push_back(a[i]);
  }
  sort(b.begin(), b.end());
  int ans = b.size() - 1;
  cout << k / b[ans];
  return 0;
}
