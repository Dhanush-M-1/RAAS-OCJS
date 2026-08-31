#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, n, l, i;
  char ch[100], ch1[100];
  string s = "", ss = "";
  scanf("%s", ch);
  scanf("%d", &n);
  l = strlen(ch);
  for (i = 0; i < l; i++) {
    if (ch[i] >= 'A' && ch[i] <= 'Z') ch[i] = (ch[i] - 'A') + 'a';
  }
  for (i = 0; i < l; i++) {
    a = ch[i];
    if (a < 97 + n)
      s += (ch[i] - 'a') + 'A';
    else
      s += ch[i];
  }
  cout << s << endl;
  return 0;
}
