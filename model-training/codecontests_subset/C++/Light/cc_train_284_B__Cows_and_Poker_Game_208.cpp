#include <bits/stdc++.h>
using namespace std;
const int INF = (int)(INT_MAX - 100);
const int N = (int)(0);
const long long mod = (int)(1e+9 + 7);
int c[3];
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int v = 0; v < n; v++) {
    if (s[v] == 'F')
      c[2]++;
    else
      c[(s[v] == 'I')]++;
  }
  int k = 0;
  for (int v = 0; v < n; v++)
    if (s[v] != 'F')
      if (c[1] - (s[v] == 'I') == 0) k++;
  printf("%d\n", k);
  return 0;
}
