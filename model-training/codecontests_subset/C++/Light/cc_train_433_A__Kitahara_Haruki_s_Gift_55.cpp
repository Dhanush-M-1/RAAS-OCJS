#include <bits/stdc++.h>
using namespace std;
unsigned long long n, i, s = 0, d = 0, a;
int main() {
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a;
    if (a == 100)
      s++;
    else
      d++;
  }
  if (s % 2 == 0 && (s != 0 || d % 2 == 0)) {
    cout << "YES";
  } else {
    cout << "NO";
    return 0;
  }
}
