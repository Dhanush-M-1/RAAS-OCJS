#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  cin >> n;
  string s;
  cin >> s;
  int a[n];
  for (i = 0; i < n; i++) {
    a[i] = s[i] - 'a';
  }
  for (i = 0; i < n; i++) {
    if (a[i] > a[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
}
