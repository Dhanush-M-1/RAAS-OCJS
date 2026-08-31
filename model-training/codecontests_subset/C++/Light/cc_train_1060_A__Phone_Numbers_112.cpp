#include <bits/stdc++.h>
using namespace std;
int n, x, a;
string s;
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; ++i) {
    if (s[i] == '8') {
      x++;
    }
  }
  a = n / 11;
  cout << min(a, x);
}
