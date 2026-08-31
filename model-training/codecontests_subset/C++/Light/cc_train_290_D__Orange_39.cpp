#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int num;
  while (cin >> s >> num) {
    transform(s.begin(), s.end(), s.begin(), ::tolower);
    for (int i = 0; i < s.size(); ++i)
      if (s[i] < 97 + num)
        s[i] = toupper(s[i]);
      else
        s[i] = tolower(s[i]);
    cout << s << endl;
  }
}
