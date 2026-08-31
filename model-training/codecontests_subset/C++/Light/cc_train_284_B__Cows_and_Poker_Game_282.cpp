#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  string str;
  cin >> str;
  int a = 0, i = 0, f = 0;
  for (int k = 0; k < str.length(); k++) {
    if (str[k] == 'A')
      a++;
    else if (str[k] == 'I')
      i++;
    else
      f++;
  }
  if (i == 1)
    cout << 1;
  else if (i == 0)
    cout << a;
  else
    cout << 0;
}
