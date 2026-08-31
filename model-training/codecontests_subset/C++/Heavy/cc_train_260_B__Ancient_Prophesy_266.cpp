#include <bits/stdc++.h>
using namespace std;
template <typename T>
void out(T x) {
  cout << x << endl;
  exit(0);
}
const int maxn = 1e6 + 5;
const string S = "dd-mm-yyyy";
int M[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool valid(string s) {
  if (s.length() != S.length()) return false;
  if (s[2] != '-') return false;
  if (s[5] != '-') return false;
  for (int i = 0; i < int(s.length()); i++) {
    if (i == 2) continue;
    if (i == 5) continue;
    if (!(s[i] >= '0' && s[i] <= '9')) return false;
  }
  int dd = stoi(s.substr(0, 2));
  int mm = stoi(s.substr(3, 2));
  int yy = stoi(s.substr(6));
  return yy >= 2013 && yy <= 2015 && mm >= 1 && mm <= 12 && dd >= 1 &&
         dd <= M[mm];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  map<string, int> mp;
  string s;
  cin >> s;
  int n = s.length();
  for (int i = 0; i + int(S.length()) <= n; i++) {
    string tmp;
    for (int j = 0; j < int(S.length()); j++) tmp += s[i + j];
    if (valid(tmp)) mp[tmp]++;
  }
  string res = "*";
  for (auto p : mp) {
    if (res == "*" || p.second > mp[res]) res = p.first;
  }
  assert(res != "*");
  cout << res << endl;
  return 0;
}
