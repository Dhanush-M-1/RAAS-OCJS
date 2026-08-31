#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, max = 0;
  string str;
  cin >> n;
  cin >> str;
  for (int i = 0; i < n; i++) {
    if (str[i] == '8') {
      max++;
    }
  }
  if (max > n / 11) {
    max = n / 11;
  }
  if (n % 11 != 0 && max > n / 11) {
    max = n / 11;
  }
  cout << max;
}
