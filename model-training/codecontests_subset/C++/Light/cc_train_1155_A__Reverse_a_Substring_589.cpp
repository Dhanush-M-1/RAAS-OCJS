#include <bits/stdc++.h>
char s[300001];
using namespace std;
int main() {
  int n, k = 0, p, r;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
  }
  for (int i = 2; i <= n; i++) {
    if (s[i] - '0' < s[i - 1] - '0') {
      cout << "YES" << endl;
      cout << i - 1 << " " << i;
      break;
    } else
      k++;
  }
  if (k == n - 1) {
    cout << "NO";
  }
}
