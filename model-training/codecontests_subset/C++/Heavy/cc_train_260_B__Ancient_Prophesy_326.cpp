#include <bits/stdc++.h>
using namespace std;
int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
map<string, int> m;
bool isok(char *ss) {
  int i = 0, cnt = 0;
  for ((i) = 0; (i) < (10); (i)++) {
    if (!isdigit(*(ss + i))) cnt++;
  }
  if (cnt == 2 && *(ss + 2) == '-' && *(ss + 5) == '-') return true;
  return false;
}
bool isvalid(char *ss) {
  int d, m, y;
  sscanf(ss, "%2d%*c%2d%*c%4d", &d, &m, &y);
  return (y >= 2013 && y <= 2015) && (m > 0 && m <= 12) &&
         (d >= 1 && d <= days[m - 1]);
}
char s[100005];
int main() {
  scanf("%s", s);
  int n = strlen(s), i, mx = 0, j;
  string ans;
  for ((i) = 0; (i) < (n - 9); (i)++) {
    if (isok(s + i) && isvalid(s + i)) {
      string a = "";
      for ((j) = 0; (j) < (10); (j)++) a.push_back(s[j + i]);
      if (m.find(a) == m.end())
        m[a] = 1;
      else
        m[a]++;
      if (m[a] > mx) {
        mx = m[a];
        ans = a;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
