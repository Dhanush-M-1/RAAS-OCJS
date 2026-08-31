#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n, i, e = 0, t = 0, c = 0;
  cin >> n >> s;
  for (i = 0; i < n; i++)
    if (s[i] == '8') e++;
  cout << min(e, n / 11) << endl;
}
