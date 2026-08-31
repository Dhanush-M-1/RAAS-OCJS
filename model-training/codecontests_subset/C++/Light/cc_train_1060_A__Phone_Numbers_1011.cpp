#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int coun = 0;
  string s;
  cin >> s;
  for (int i = 0; i < n; i += 1) {
    if (s[i] == '8') coun++;
  }
  cout << min(coun, n / 11);
  return 0;
}
