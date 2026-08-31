#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, k = 0;
  cin >> n;
  vector<int> a;
  int mx = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    a.push_back(x);
    if (x > mx) mx = x;
    k += x;
  }
  int j = mx;
  while (true) {
    int s = 0;
    for (int i = 0; i < n; i++) s += j - a[i];
    if (s > k) {
      cout << j;
      break;
    }
    j++;
  }
  return 0;
}
