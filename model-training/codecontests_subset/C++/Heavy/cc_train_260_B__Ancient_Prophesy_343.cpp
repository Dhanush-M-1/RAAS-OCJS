#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
const int INF = 1 << 30;
const int base = 1000 * 1000 * 1000;
const int N = 1100000;
const int DAYS[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
char s[110000] = {};
map<string, int> M;
int len = 0;
void Solve() {
  char date[11] = "01-01-2013";
  for (int i = 3; i < 6; i++)
    for (int j = 1; j < 13; j++)
      for (int day = 1; day <= DAYS[j - 1]; day++) {
        date[0] = day / 10 + '0';
        date[1] = day % 10 + '0';
        date[3] = j / 10 + '0';
        date[4] = j % 10 + '0';
        date[9] = i + '0';
        int Count = 0;
        for (int k = 0; k < len - 9; k++)
          if (strncmp(&s[k], date, 10) == 0) Count++;
        M[date] = Count;
      }
}
int main() {
  gets(s);
  len = strlen(s);
  Solve();
  string answ;
  int Max = -1;
  for (map<string, int>::iterator it = M.begin(); it != M.end(); it++)
    if (it->second > Max) {
      answ = it->first;
      Max = it->second;
    }
  for (int i = 0; i < answ.size(); i++) putchar(answ[i]);
  putchar('\n');
  return 0;
}
