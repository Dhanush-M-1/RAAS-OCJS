#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int cnt = 0, count = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') cnt++;
  }
  while (cnt) {
    n = n - 1;
    cnt = cnt - 1;
    if (n / 10 > 0) {
      count++;
      n = n - 10;
    }
  }
  cout << count;
}
