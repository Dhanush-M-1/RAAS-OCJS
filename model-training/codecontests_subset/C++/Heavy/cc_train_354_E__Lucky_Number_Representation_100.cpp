#include <bits/stdc++.h>
using namespace std;
char beau[3] = {'0', '4', '7'};
string s;
string s1, s2, s3, s4, s5, s6;
bool chk[20][20];
void fix(string r) {
  while (r[0] == '0' && r.size() > 1) r.erase(0, 1);
  for (int i = 0; i < r.size(); i++) cout << r[i];
  cout << ' ';
}
bool f(int n, int carry) {
  if (n == s.size()) {
    if (carry == 0)
      return true;
    else
      return false;
  }
  if (chk[n][carry]) return false;
  chk[n][carry] = 1;
  for (int i = 0; i < 3; i++)
    for (int j = 0; j < 3; j++)
      for (int k = 0; k < 3; k++)
        for (int q = 0; q < 3; q++)
          for (int w = 0; w < 3; w++)
            for (int e = 0; e < 3; e++) {
              int z = beau[i] - '0' + beau[j] - '0' + beau[k] - '0' + beau[q] -
                      '0' + beau[w] - '0' + beau[e] - '0' + carry;
              if (s[n] - '0' == z % 10 && f(n + 1, z / 10)) {
                s1 += beau[i];
                s2 += beau[j];
                s3 += beau[k];
                s4 += beau[q];
                s5 += beau[w];
                s6 += beau[e];
                return true;
              }
            }
  return false;
}
int main() {
  int t;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    memset(chk, 0, sizeof(chk));
    cin >> s;
    reverse(s.begin(), s.end());
    s1 = s2 = s3 = s4 = s5 = s6 = "";
    if (!f(0, 0)) {
      cout << -1 << endl;
      continue;
    } else {
      fix(s1);
      fix(s2);
      fix(s3);
      fix(s4);
      fix(s5);
      fix(s6);
      cout << endl;
    }
  }
}
