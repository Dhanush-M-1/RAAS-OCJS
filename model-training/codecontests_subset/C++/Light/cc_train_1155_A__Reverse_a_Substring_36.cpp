#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c, d, e, g, h, i, j, k, l, m, n;
  cin >> a;
  string s;
  cin >> s;
  string S = s;
  sort(s.begin(), s.end());
  if (s == S) {
    cout << "NO";
  } else {
    cout << "YES"
         << "\n";
    char ans;
    int J, j;
    for (i = 0; i < a - 1; i++) {
      if (S[i] > S[i + 1]) {
        cout << i + 1 << " " << i + 2;
        break;
      }
    }
  }
}
