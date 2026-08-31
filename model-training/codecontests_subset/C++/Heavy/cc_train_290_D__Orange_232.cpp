#include <bits/stdc++.h>
using namespace std;
__inline bool nextInt(int &val) {
  char ch;
  int sgn = 1;
  while ((ch = getchar()) != EOF) {
    if (ch == '-') sgn = -1;
    if (ch >= '0' && ch <= '9') break;
  }
  if (ch == EOF) return false;
  val = (int)(ch - '0');
  while (true) {
    ch = getchar();
    if (ch >= '0' && ch <= '9') {
      val = 10 * val + (int)(ch - '0');
    } else
      break;
  }
  val *= sgn;
  return true;
}
__inline bool nextString(string &s) {
  char ch;
  while ((ch = getchar()) != EOF) {
    if (ch >= 33 && ch <= 126) break;
  }
  if (ch == EOF) return false;
  s = string(1, ch);
  while (true) {
    ch = getchar();
    if (ch >= 33 && ch <= 126) {
      s = s + string(1, ch);
    } else
      break;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  string s, o;
  int n;
  cin >> s >> n;
  o = "";
  for (int i = 0; i < (s.size()); i++)
    if ((int)((s[i]) >= 'a' && (s[i]) <= 'z'
                  ? (s[i])
                  : (char)('a' + ((s[i]) - 'A'))) < n + 97)
      o += string(
          1, ((s[i]) >= 'A' && (s[i]) <= 'Z' ? (s[i])
                                             : (char)('A' + ((s[i]) - 'a'))));
    else
      o += string(
          1, ((s[i]) >= 'a' && (s[i]) <= 'z' ? (s[i])
                                             : (char)('a' + ((s[i]) - 'A'))));
  cout << o << endl;
  return 0;
}
