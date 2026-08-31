#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, k;
  string s;
  cin >> n;
  cin >> s;
  int flag = 0;
  j = 0;
  for (i = 0; i < n; i++)
    if (s[i] == 'A')
      j++;
    else if (s[i] == 'I' && flag == 0)
      flag = 1;
    else if (s[i] == 'I' && flag == 1)
      flag = 2;
  if (!flag)
    cout << j << endl;
  else if (flag == 1)
    cout << "1" << endl;
  else
    cout << "0" << endl;
  return 0;
}
