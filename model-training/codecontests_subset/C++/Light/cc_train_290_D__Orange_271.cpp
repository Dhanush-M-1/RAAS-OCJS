#include <bits/stdc++.h>
using namespace std;
char lower(char c) {
  if (c < 97) c += 32;
  return c;
}
char upper(char c) {
  if (c >= 97) c -= 32;
  return c;
}
int main() {
  string in;
  int n;
  cin >> in;
  cin >> n;
  int len = in.length();
  string out;
  for (int i = 0; i < len; i++) {
    char tmp = lower(in[i]);
    if (tmp < n + 97)
      out += upper(tmp);
    else
      out += tmp;
  }
  cout << out << endl;
  return 0;
}
