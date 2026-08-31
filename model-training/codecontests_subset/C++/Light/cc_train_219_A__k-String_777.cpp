#include <bits/stdc++.h>
using namespace std;
string s, m;
int n, i, a[130], j;
int main() {
  cin >> n >> s;
  for (; i < s.size(); i++) a[s[i]]++;
  for (i = 64; i < 123; i++)
    if (a[i] % n != 0) {
      cout << -1;
      return 0;
    } else if (a[i] > 0)
      for (j = 0; j < a[i] / n; j++) m += i;
  for (i = 0; i < n; i++) cout << m;
}
