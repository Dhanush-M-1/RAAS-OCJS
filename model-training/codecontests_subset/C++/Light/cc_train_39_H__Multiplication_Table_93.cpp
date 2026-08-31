#include <bits/stdc++.h>
using namespace std;
int n, w = 1, j, sum;
string s;
int main() {
  cin >> n;
  for (w = 1; w < n; w++) {
    for (j = 1; j < n; j++) {
      sum = j * w;
      while (sum > 0) {
        s += sum % n + '0';
        sum /= n;
      }
      reverse(s.begin(), s.end());
      cout << s << " ";
      s.clear();
      if (j == n - 1) {
        cout << "\n";
      }
    }
  }
  return 0;
}
