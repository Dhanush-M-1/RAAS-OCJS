#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0, i, input, even = 0, odd = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> input;
    if (input == 100) {
      odd++;
    } else {
      even++;
    }
  }
  if (odd % 2 == 0 && odd >= even % 2) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
