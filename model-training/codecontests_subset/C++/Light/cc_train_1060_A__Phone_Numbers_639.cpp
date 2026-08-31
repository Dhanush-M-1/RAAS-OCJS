#include <bits/stdc++.h>
using namespace std;
int u[200];
int main() {
  int n;
  string s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) u[s[i] - '0']++;
  cout << min(u[8], (n / 11)) << endl;
}
