#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0;
  cin >> n;
  int a[n + 5], h[n + 5];
  for (int i = 0; i < n; i++) cin >> h[i] >> a[i];
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (a[i] == h[j]) sum++;
      if (h[i] == a[j]) sum++;
    }
  }
  cout << sum << endl;
  return 0;
}
