#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt = 0, k = 0;
  cin >> n;
  string s;
  cin >> s;
  k = n / 11;
  for (int i = 0; i < n; i++)
    if (s[i] == '8') cnt++;
  cout << min(k, cnt);
}
