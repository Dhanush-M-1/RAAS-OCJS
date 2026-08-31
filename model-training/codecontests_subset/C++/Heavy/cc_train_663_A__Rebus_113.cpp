#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
const int mod = 1e6 + 3;
void rd(int &x) {
  int f = 1;
  x = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  x *= f;
}
void pr(int x) { printf("%d\n", x); }
string s, t;
int n;
vector<string> g;
int main() {
  getline(cin, s);
  stringstream ss;
  ss << s;
  int sum = 0, fu = 0, zh = 0;
  while (ss >> t) {
    g.push_back(t);
    if (t == "?") sum++;
    if (t == "-") fu++;
  }
  zh = sum - fu;
  t = g[g.size() - 1];
  for (int i = (0); i < t.size(); i++) n = n * 10 + t[i] - '0';
  int m = n + fu, fir;
  if (fu) {
    if (m > n * zh && zh > fu * n + n)
      puts("Impossible");
    else {
      int avg, sum, yu;
      if (zh > fu) {
        sum = (fu + 1) * n;
        avg = sum / zh;
        yu = sum % zh;
        if (avg == 0)
          puts("Impossible");
        else {
          puts("Possible");
          if (yu)
            printf("%d", avg + 1), yu--;
          else
            printf("%d", avg);
          for (int i = (1); i < g.size() - 1; i++) {
            if (g[i] != "?")
              cout << " " << g[i];
            else {
              if (g[i - 1] == "+") {
                if (yu)
                  printf(" %d", avg + 1), yu--;
                else
                  printf(" %d", avg);
              } else
                printf(" %d", n);
            }
          }
          printf(" %d\n", n);
        }
      } else {
        sum = n * (zh - 1);
        avg = sum / fu;
        yu = sum % fu;
        if (avg == 0)
          puts("Impossible");
        else {
          puts("Possible");
          printf("%d", n);
          for (int i = (1); i < g.size() - 1; i++) {
            if (g[i] != "?")
              cout << " " << g[i];
            else {
              if (g[i - 1] == "-") {
                if (yu)
                  printf(" %d", avg + 1), yu--;
                else
                  printf(" %d", avg);
              } else
                printf(" %d", n);
            }
          }
          printf(" %d\n", n);
        }
      }
    }
  } else {
    if (zh > n)
      puts("Impossible");
    else {
      puts("Possible");
      int x = zh - 1, fir = n - x;
      printf("%d", fir);
      for (int i = (1); i < g.size() - 1; i++) {
        if (g[i] != "?")
          cout << " " << g[i];
        else
          cout << " 1";
      }
      printf(" %d\n", n);
    }
  }
}
