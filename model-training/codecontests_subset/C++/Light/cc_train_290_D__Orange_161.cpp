#include <bits/stdc++.h>
using namespace std;
string ToLower(string sOrigin) {
  string ans("");
  long i;
  for (i = 0; i <= sOrigin.length() - 1; ++i) {
    if (sOrigin[i] >= 'A' && sOrigin[i] <= 'Z')
      ans += char(sOrigin[i] + ('a' - 'A'));
    else
      ans += sOrigin[i];
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  string sOrig;
  int iNum, iLength, i;
  getline(cin, sOrig);
  cin >> iNum;
  iLength = sOrig.length() - 1;
  sOrig = ToLower(sOrig);
  for (i = 0; i <= iLength; ++i) {
    if (sOrig[i] < 'a' + iNum) sOrig[i] = sOrig[i] + 'A' - 'a';
  }
  cout << sOrig;
  return 0;
}
