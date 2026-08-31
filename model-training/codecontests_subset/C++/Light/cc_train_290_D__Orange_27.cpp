#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  string H = "";
  string s;
  int num;
  cin >> s >> num;
  for (unsigned int i = 0; i < s.size(); i++) {
    if ((int)tolower(s[i]) < num + 97)
      H += (toupper(s[i]));
    else
      H += (tolower(s[i]));
    cout << H[i];
  }
}
