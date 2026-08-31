#include <bits/stdc++.h>
using namespace std;
int k;
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      int n = i * j;
      string s;
      while (n) {
        s = char((n % k) + '0') + s;
        n /= k;
      }
      cout << s << " ";
    }
    cout << endl;
  }
}
