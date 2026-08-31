#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int a = n / 11, d = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      d++;
    }
  }
  cout << min(d, a);
}
