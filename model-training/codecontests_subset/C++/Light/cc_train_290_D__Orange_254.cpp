#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  int b;
  cin >> a;
  cin >> b;
  for (int(i) = (0); (i) < (int((a).size())); (i)++) a[i] = tolower(a[i]);
  string ret = "";
  for (int(i) = (0); (i) < (int((a).size())); (i)++) {
    char c = a[i];
    if ((int)c < b + 97)
      ret += toupper(c);
    else
      ret += c;
  }
  cout << ret << endl;
}
