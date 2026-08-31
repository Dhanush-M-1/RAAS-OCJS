#include <bits/stdc++.h>
using namespace std;
map<string, int> f;
int k[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool invalid(char a) { return a == '-'; }
void calc(string s) {
  if (s[2] != '-' || s[5] != '-') return;
  for (int i = 0; i < s.length(); i++)
    if (i == 2 || i == 5)
      continue;
    else if (invalid(s[i]))
      return;
  string d = s.substr(0, 2), m = s.substr(3, 2), y = s.substr(6, 4);
  int year = atoi(y.c_str()), month = atoi(m.c_str()), day = atoi(d.c_str());
  if (year < 2013 || year > 2015 || month < 1 || month > 12 || day < 1 ||
      day > k[month])
    return;
  f[s]++;
}
int main() {
  int maxi = -1;
  string s, MX = "";
  cin >> s;
  for (int i = 0; i < s.size() - 9; i++) calc(s.substr(i, 10));
  for (map<string, int>::iterator it = f.begin(); it != f.end(); it++)
    if (it->second > maxi) maxi = it->second, MX = it->first;
  cout << MX << endl;
  return 0;
}
