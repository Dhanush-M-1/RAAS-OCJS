#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e9;
map<string, int> my_map;
int m_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  string inp;
  cin >> inp;
  for (int i = 0; i < inp.size(); i++) {
    string buff = inp.substr(i, 10);
    bool flag = false;
    if (buff[2] != '-' || buff[5] != '-') flag = true;
    for (int j = 0; j < 10; j++)
      if (j != 2 && j != 5 && buff[j] == '-') flag = true;
    if (flag) continue;
    int date = (buff[0] - '0') * 10 + (buff[1] - '0');
    int month = (buff[3] - '0') * 10 + (buff[4] - '0');
    int year = (buff[6] - '0') * 1000 + (buff[7] - '0') * 100 +
               (buff[8] - '0') * 10 + (buff[9] - '0');
    if (year >= 2013 && year <= 2015)
      if (month >= 1 && month <= 12)
        if (date && date <= m_days[month - 1]) my_map[buff]++;
  }
  map<string, int>::iterator mx = my_map.begin();
  for (map<string, int>::iterator i = mx; i != my_map.end(); i++)
    if (i->second > mx->second) mx = i;
  cout << mx->first << endl;
  return 0;
}
