#include <bits/stdc++.h>
using namespace std;
char s[100];
int a;
int main(void) {
  scanf("%s", &s);
  scanf("%d", &a);
  string b = (string)s;
  string c = "";
  string res = "";
  for (int i = 0; i < b.length(); i++)
    if ((b[i] >= 'A') && (b[i] <= 'Z'))
      c += 'a' + (b[i] - 'A');
    else
      c += b[i];
  for (int i = 0; i < c.length(); i++) {
    if (c[i] < a + 97)
      res += 'A' + (c[i] - 'a');
    else
      res += c[i];
  }
  printf("%s\n", res.c_str());
  return 0;
}
