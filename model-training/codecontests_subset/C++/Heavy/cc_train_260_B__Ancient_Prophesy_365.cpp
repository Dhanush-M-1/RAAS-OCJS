#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:66777216")
using namespace std;
typedef struct coor {
  int x, y;
};
int nomalDay[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int leapDay[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
const int ARRSIZE = 100100;
const int STRSIZE = 100100;
const int GRIDSIZE = 510;
const int MAXINF = (2 << 20);
const int MININF = (~(2 << 20));
inline bool upcmp(int a, int b) { return a < b; }
inline bool downcmp(int a, int b) { return a > b; }
int hs[50][50][10];
int main() {
  string s, res;
  cin >> s;
  int i, j, len = (int)s.size(), Max = MININF;
  for (i = 0; i < len - 8; i++) {
    string tp = "";
    int cnt = 0;
    for (j = 0; j < 10; j++) {
      tp += s[i + j];
      if (s[i + j] == '-') cnt++;
    }
    if (cnt > 2) continue;
    int day = (tp[0] - '0') * 10 + tp[1] - '0';
    int mon = (tp[3] - '0') * 10 + tp[4] - '0';
    int year = (tp[6] - '0') * 1000 + (tp[7] - '0') * 100 + (tp[8] - '0') * 10 +
               tp[9] - '0';
    if (tp[2] != '-' || tp[5] != '-') continue;
    if (year < 2013 || year > 2015) continue;
    if (mon < 1 || mon > 12) continue;
    if (day > nomalDay[mon] || day < 1) continue;
    int h1 = hs[day][mon][year - 2013]++;
    h1++;
    if (h1 > Max) {
      res = tp;
      Max = h1;
    }
  }
  cout << res << endl;
  return 0;
}
