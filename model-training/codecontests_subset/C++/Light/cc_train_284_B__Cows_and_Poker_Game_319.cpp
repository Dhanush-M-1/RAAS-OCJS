#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n, a, f, i, j, count;
  a = f = i = count = 0;
  cin >> n;
  char s[n];
  for (j = 0; j < n; j++) {
    cin >> s[j];
    if (s[j] == 'F')
      f++;
    else if (s[j] == 'A')
      a++;
    else if (s[j] == 'I')
      i++;
  }
  if (i > 1)
    count = 0;
  else if (i == 1)
    count = 1;
  else
    count = a;
  cout << count;
}
