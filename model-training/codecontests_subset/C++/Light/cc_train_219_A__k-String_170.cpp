#include <bits/stdc++.h>
using namespace std;
const int c = 220000;
int main() {
  int a[300], k;
  string second;
  cin >> k >> second;
  memset(a, 0, sizeof(a));
  for (int i = 0; i < second.size(); i++) a[second[i] - 'a']++;
  bool p = 1;
  for (int i = 0; i <= 'z' - 'a'; i++)
    if (a[i] % k != 0) p = 0;
  if (p)
    for (int i = 0; i < k; i++)
      for (int j = 0; j <= 'z' - 'a'; j++)
        for (int u = 0; u < a[j] / k; u++) cout << char('a' + j);
  else
    cout << -1;
  return 0;
}
