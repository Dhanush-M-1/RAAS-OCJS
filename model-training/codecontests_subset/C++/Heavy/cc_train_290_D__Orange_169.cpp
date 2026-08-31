#include <bits/stdc++.h>
using namespace std;
double EPS = 1e-9;
int INF = 2000000000;
long long INFF = 8000000000000000000LL;
double PI = acos(-1);
int dirx[8] = {-1, 0, 0, 1, -1, -1, 1, 1};
int diry[8] = {0, 1, -1, 0, -1, 1, -1, 1};
inline string IntToString(int a) {
  char x[100];
  sprintf(x, "%d", a);
  string s = x;
  return s;
}
inline int StringToInt(string a) {
  char x[100];
  int res;
  strcpy(x, a.c_str());
  sscanf(x, "%d", &res);
  return res;
}
inline string GetString(void) {
  char x[1000005];
  scanf("%s", x);
  string s = x;
  return s;
}
inline string uppercase(string s) {
  int n = (int)s.size();
  for (int(i) = (0); (i) < (n); ++(i))
    if (s[i] >= 'a' && s[i] <= 'z') s[i] = s[i] - 'a' + 'A';
  return s;
}
inline string lowercase(string s) {
  int n = (int)s.size();
  for (int(i) = (0); (i) < (n); ++(i))
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] - 'A' + 'a';
  return s;
}
inline void OPEN(string s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
string s;
int n;
int main() {
  s = GetString();
  scanf("%d", &n);
  s = lowercase(s);
  int m = (int)s.size();
  for (int(i) = (0); (i) < (m); ++(i)) {
    if (s[i] < n + 97) s[i] = s[i] - 'a' + 'A';
  }
  printf("%s\n", s.c_str());
  return 0;
}
