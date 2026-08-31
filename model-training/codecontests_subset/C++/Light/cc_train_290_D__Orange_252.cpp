#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:100000000")
int main() {
  string s;
  cin >> s;
  int n;
  scanf("%d", &n);
  for (int i = 0, maxi = (int)(s).size(); i < maxi; i++) {
    if (s[i] >= 'a' && s[i] <= 'z' && s[i] - 'a' < n) s[i] += 'A' - 'a';
    if (s[i] >= 'A' && s[i] <= 'Z' && s[i] - 'A' >= n) s[i] -= 'A' - 'a';
  }
  cout << s << endl;
  return 0;
}
