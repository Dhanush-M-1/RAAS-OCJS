#include <bits/stdc++.h>
using namespace std;
int n;
char a[105];
int main(void) {
  int x = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == '8') x++;
  }
  cout << min(x, n / 11) << endl;
  return 0;
}
