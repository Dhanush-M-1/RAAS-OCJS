#include <bits/stdc++.h>
using namespace std;
int a[4];
int main() {
  ios_base::sync_with_stdio(0);
  string str;
  int q = 0;
  cin >> str;
  for (int i = 0; i < str.size(); i++) {
    int x = str[i] - '0';
    x = max(x, 0);
    a[x]++;
    if (x != 0) q++;
  }
  for (int i = 1; i <= 3; i++)
    for (int j = 0; j < a[i]; j++) {
      if (q == 1)
        cout << i;
      else
        cout << i << "+";
      q--;
    }
}
