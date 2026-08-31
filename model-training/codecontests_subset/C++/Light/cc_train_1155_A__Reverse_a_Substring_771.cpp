#include <bits/stdc++.h>
using namespace std;
char a[300010];
int main() {
  int n, i;
  cin >> n;
  cin >> a + 1;
  for (i = 1; i < n; i++) {
    if (a[i] > a[i + 1]) {
      cout << "YES" << endl;
      cout << i << ' ' << i + 1;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
