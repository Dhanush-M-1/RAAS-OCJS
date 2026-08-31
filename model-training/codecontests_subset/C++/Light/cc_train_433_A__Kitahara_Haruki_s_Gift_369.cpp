#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long int n;
  cin >> n;
  long long int A[n];
  long long int n1 = 0, n2 = 0;
  for (long long int i = 0; i < n; i++) {
    cin >> A[i];
    if (A[i] == 100)
      n1++;
    else
      n2++;
  }
  if (n1 % 2 == 1 && n2 % 2 == 0) {
    cout << "NO" << endl;
    ;
  } else if (n1 % 2 == 1 && n2 % 2 == 1) {
    cout << "NO" << endl;
    ;
  } else if (n1 % 2 == 0 && n2 % 2 == 0) {
    cout << "YES" << endl;
    ;
  } else if (n1 % 2 == 0 && n2 % 2 == 1 && n1 > 0) {
    cout << "YES" << endl;
    ;
  } else {
    cout << "NO" << endl;
  };
}
