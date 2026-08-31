#include <bits/stdc++.h>
using namespace std;
const int M = 1e5 + 5;
char pro[M];
map<string, int> mp;
int moon[15] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool OK(string a) {
  int len = a.length();
  int year, month, day;
  year = (a[len - 4] - '0') * 1000 + (a[len - 3] - '0') * 100 +
         (a[len - 2] - '0') * 10 + (a[len - 1] - '0');
  if (year > 2015 || year < 2013) {
    return false;
  }
  month = (a[len - 7] - '0') * 10 + (a[len - 6] - '0');
  if (month < 1 || month > 12) {
    return false;
  }
  day = (a[len - 10] - '0') * 10 + (a[len - 9] - '0');
  if (day < 1 || day > moon[month]) {
    return false;
  }
  return true;
}
bool judge(int i) {
  if (pro[i] != '-' && pro[i + 1] != '-' && pro[i + 2] == '-' &&
      pro[i + 3] != '-' && pro[i + 4] != '-' && pro[i + 5] == '-' &&
      pro[i + 6] != '-' && pro[i + 7] != '-' && pro[i + 8] != '-' &&
      pro[i + 9] != '-') {
    return true;
  }
  return false;
}
int main() {
  scanf("%s", pro);
  int len = strlen(pro);
  for (int i = 0; i < len - 9; i++) {
    if (judge(i)) {
      char temp[15];
      memcpy(temp, pro + i, 10);
      temp[10] = '\0';
      mp[temp]++;
    }
  }
  map<string, int>::iterator k = mp.begin();
  int num = 0;
  string ans;
  for (; k != mp.end(); k++) {
    if (num < (k->second) && OK(k->first)) {
      num = (k->second);
      ans = k->first;
    }
  }
  cout << ans << endl;
  return 0;
}
