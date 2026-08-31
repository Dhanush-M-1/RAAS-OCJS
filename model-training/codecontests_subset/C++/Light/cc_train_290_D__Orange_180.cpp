#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int i = 0;
  int j;
  char c, a[100];
  while (1) {
    c = getchar();
    if (c == '\n') break;
    a[i++] = tolower(c);
  }
  a[i] = '\0';
  cin >> n;
  for (j = 0; j < i; j++) {
    if ((int)(a[j]) < (n + 97))
      a[j] = toupper(a[j]);
    else
      a[j] = tolower(a[j]);
    cout << a[j];
  }
  cout << endl;
  return 0;
}
