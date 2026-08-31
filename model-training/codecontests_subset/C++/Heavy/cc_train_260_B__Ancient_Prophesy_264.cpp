#include <bits/stdc++.h>
using namespace std;
char s[100005];
int num[100005];
map<int, string> ans;
map<string, int> mp;
int mouth[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int k = 1;
void judge(int i) {
  char ss[20];
  int l = 0;
  if (s[i + 2] != '-' || s[i + 5] != '-') return;
  for (int j = i; j < i + 10; j++) {
    ss[l++] = s[j];
    if (j == i + 2 || j == i + 5) continue;
    if (!(s[j] >= '0' && s[j] <= '9')) return;
  }
  ss[l] = '\0';
  int dd = (s[i] - '0') * 10 + s[i + 1] - '0';
  int mm = (s[i + 3] - '0') * 10 + s[i + 4] - '0';
  int yy = 0;
  for (int j = i + 6; j < i + 10; j++) {
    yy = yy * 10 + s[j] - '0';
  }
  if (!(yy >= 2013 && yy <= 2015)) return;
  if (!(mm >= 1 && mm <= 12)) return;
  if (!(dd >= 1 && dd <= mouth[mm])) return;
  if (!mp[ss]) {
    ans[k] = ss;
    mp[ss] = k++;
  }
  num[mp[ss]]++;
}
int main() {
  cin >> s;
  int len = strlen(s);
  for (int i = 0; i <= len - 10; i++) {
    judge(i);
  }
  int index, max_ = -1;
  for (int i = 1; i < k; i++) {
    if (num[i] > max_) {
      max_ = num[i];
      index = i;
    }
  }
  cout << ans[index];
  return 0;
}
