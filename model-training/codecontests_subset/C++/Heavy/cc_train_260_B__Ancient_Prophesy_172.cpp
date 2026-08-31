#include <bits/stdc++.h>
using namespace std;
char s[100010];
int mon[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int anum;
map<string, int> ms;
bool isnum(char a) { return a >= '0' && a <= '9'; }
int main() {
  while (~scanf("%s", s)) {
    ms.clear();
    anum = 0;
    int tmp = 0;
    string tt;
    int max = 0;
    for (int i = 0; s[i + 9] != 0; i++) {
      if (isnum(s[i]) && isnum(s[i + 1]) && !isnum(s[i + 2]) &&
          isnum(s[i + 3]) && isnum(s[i + 4]) && !isnum(s[i + 5]) &&
          isnum(s[i + 6]) && isnum(s[i + 7]) && isnum(s[i + 8]) &&
          isnum(s[i + 9])) {
        int a0 = atoi(s + i), a1 = atoi(s + i + 3), a2;
        char ttt = s[i + 10];
        s[i + 10] = 0;
        a2 = atoi(s + i + 6);
        s[i + 10] = ttt;
        if (a2 <= 2015 && a2 >= 2013 && a1 <= 12 && a1 >= 1 && a0 > 0 &&
            a0 <= mon[a1]) {
          ms[string(s + i, s + i + 10)]++;
          if (ms[string(s + i, s + i + 10)] > max) {
            tt = string(s + i, s + i + 10);
            max = ms[tt];
          }
        }
      }
    }
    printf("%s", tt.c_str());
    puts("");
  }
}
