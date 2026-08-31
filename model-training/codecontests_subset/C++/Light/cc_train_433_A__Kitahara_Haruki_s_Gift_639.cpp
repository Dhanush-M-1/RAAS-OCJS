#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long a[n];
  long long c1 = 0, c2 = 0;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100) {
      c1++;
    } else {
      c2++;
    }
  }
  if (c1 > 0) {
    if (c1 % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  } else {
    if (c2 % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  }
}
