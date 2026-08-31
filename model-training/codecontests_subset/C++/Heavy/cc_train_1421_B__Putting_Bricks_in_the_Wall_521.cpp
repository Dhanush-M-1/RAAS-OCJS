#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    string arr[n];
    for (long long int i = 0; i < n; i++) cin >> arr[i];
    char s1 = arr[0][1];
    char s2 = arr[1][0];
    char e1 = arr[n - 2][n - 1];
    char e2 = arr[n - 1][n - 2];
    if ((s1 == s2) && (e1 == e2) && s1 == e1) {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << 2 << " " << 1 << endl;
    } else if ((s1 == s2) && (e1 == e2) && s1 != e1)
      cout << 0 << endl;
    else if ((s1 != s2) && (e1 != e2) && s1 == e1) {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << n << " " << n - 1 << endl;
    } else if ((s1 != s2) && (e1 != e2) && s1 != e1) {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << n - 1 << " " << n << endl;
    } else if ((s1 == s2) && (e1 != e2) && s1 == e1) {
      cout << 1 << endl;
      cout << n - 1 << " " << n << endl;
    } else if ((s1 == s2) && (e1 != e2) && s1 == e2) {
      cout << 1 << endl;
      cout << n << " " << n - 1 << endl;
    } else if ((s1 != s2) && (e1 == e2) && s1 == e1) {
      cout << 1 << endl;
      cout << 1 << " " << 2 << endl;
    } else if ((s1 != s2) && (e1 == e2) && s2 == e1) {
      cout << 1 << endl;
      cout << 2 << " " << 1 << endl;
    }
  }
  return 0;
}
