#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int arr[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
char str[maxn];
map<string, int> mp;
struct CmpByValue {
  bool operator()(const pair<string, int>& lhs, const pair<string, int>& rhs) {
    return lhs.second > rhs.second;
  }
};
int check(int x) {
  int flag[5] = {0}, numd = 0, numm = 0, numy = 0;
  if (isdigit(str[x - 1]) && isdigit(str[x - 2]))
    flag[0] = 1, numd = (str[x - 2] - '0') * 10 + (str[x - 1] - '0');
  if (isdigit(str[x + 1]) && isdigit(str[x + 2]))
    flag[1] = 1, numm = (str[x + 1] - '0') * 10 + (str[x + 2] - '0');
  for (int i = x + 4; i < x + 8; i++)
    if (isdigit(str[i]))
      numy = numy * 10 + (str[i] - '0');
    else
      return 0;
  if (flag[0] && flag[1]) {
    if (2013 <= numy && numy <= 2015) {
      if (1 <= numm && numm <= 12) {
        if (0 < numd && numd <= arr[numm])
          return 1;
        else
          return 0;
      } else
        return 0;
    } else
      return 0;
  } else
    return 0;
}
int main() {
  scanf("%s", str);
  int n = strlen(str);
  for (int i = 0; i < n; i++) {
    if (str[i] == '-' && str[i + 3] == '-') {
      if (i - 2 < 0 || i + 7 >= n) continue;
      if (check(i)) {
        string s;
        for (int j = i - 2; j <= i + 7; j++) s += str[j];
        mp[s]++;
      }
    }
  }
  vector<pair<string, int> > vec(mp.begin(), mp.end());
  sort(vec.begin(), vec.end(), CmpByValue());
  pair<string, int> p = vec[0];
  cout << p.first << endl;
  return 0;
}
