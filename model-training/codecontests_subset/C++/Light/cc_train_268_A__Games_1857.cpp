#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0, maxx = 0;
  int h[110], a[110];
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> h[i] >> a[i];
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (j == i) continue;
      if (h[i] == a[j]) sum++;
    }
  }
  cout << sum << endl;
  return 0;
}
