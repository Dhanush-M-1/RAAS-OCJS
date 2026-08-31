#include <bits/stdc++.h>
using namespace std;
int toNum(string s) {
  int ans = 0;
  for (int i = 0; i < s.size(); i++)
    if (s[i] >= '0' && s[i] <= '9') {
      ans = ans * 10 + (s[i] - '0');
    } else
      return -1;
  return ans;
}
bool check(string s) {
  if (s[2] != '-' || s[5] != '-') return 0;
  string ngay = s.substr(0, 2);
  int Ngay = toNum(ngay);
  if (Ngay < 1 || Ngay > 31) return 0;
  string thang = s.substr(3, 2);
  int Thang = toNum(thang);
  if (Thang < 1 || Thang > 12) return 0;
  string nam = s.substr(6, 4);
  int Nam = toNum(nam);
  if (Nam < 2013 || Nam > 2015) return 0;
  if (Thang == 4 || Thang == 6 || Thang == 9 || Thang == 11)
    if (Ngay > 30) return 0;
  if (Thang == 2 && Ngay > 28) return 0;
  return 1;
}
string s;
map<string, int> m;
map<string, int>::iterator it;
int main() {
  cin >> s;
  for (int i = 0; i < s.size() - 9; i++)
    if (s[i] != '-') {
      string tmp = s.substr(i, 10);
      if (check(tmp)) m[tmp]++;
    }
  string ans = "1";
  m[ans] = 0;
  for (it = m.begin(); it != m.end(); it++) {
    if (it->second > m[ans]) ans = it->first;
  }
  cout << ans << endl;
  return 0;
}
