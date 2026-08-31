#include <bits/stdc++.h>
using namespace std;
char sc[100], c;
string s, answer;
int x, i;
int main() {
  scanf("%s", sc);
  s = sc;
  for (i = 0; i < s.length(); i++) s[i] = tolower(s[i]);
  scanf("%d", &x);
  answer = "";
  for (i = 0; i < s.length(); i++) {
    c = s[i];
    if (c < x + 97) {
      answer += toupper(c);
    } else {
      answer += tolower(c);
    }
  }
  printf("%s\n", answer.c_str());
  return 0;
}
