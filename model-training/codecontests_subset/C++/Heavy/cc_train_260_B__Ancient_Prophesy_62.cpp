#include <bits/stdc++.h>
using namespace std;
int n;
long long table[40][40];
long long solve(int nodes, int h) {
  if (nodes == 0) {
    return 1LL;
  }
  if (h == 0) {
    return 0;
  }
  long long &ret = table[nodes][h];
  if (ret != -1) return ret;
  ret = 0;
  for (int i = 0; i < nodes; ++i) {
    ret += solve(i, max(h - 1, 0)) * solve(nodes - i - 1, max(h - 1, 0));
  }
  return ret;
}
string days[] = {"01", "02", "03", "04", "05", "06", "07", "08",
                 "09", "10", "11", "12", "13", "14", "15", "16",
                 "17", "18", "19", "20", "21", "22", "23", "24",
                 "25", "26", "27", "28", "29", "30", "31"};
string months[] = {"01", "02", "03", "04", "05", "06",
                   "07", "08", "09", "10", "11", "12"};
int lim[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int fail[100];
char t[100010], p[100];
inline void buildFail() {
  int m = strlen(p);
  int j = fail[0] = -1;
  for (int i = 1; i <= m; ++i) {
    while (j >= 0 && p[j] != p[i - 1]) j = fail[j];
    fail[i] = ++j;
  }
}
int match() {
  int n = strlen(t), m = strlen(p);
  int count = 0;
  for (int i = 0, k = 0; i < n; ++i) {
    while (k >= 0 && p[k] != t[i]) k = fail[k];
    if (++k >= m) {
      ++count;
      k = fail[k];
    }
  }
  return count;
}
int main() {
  string in;
  cin >> t;
  int maxo = 0, koko;
  string ans;
  string tmpo;
  for (int i = 0; i < 12; ++i) {
    for (int j = 0; j < lim[i]; ++j) {
      tmpo = days[j] + "-" + months[i] + "-" + "2013";
      strcpy(p, tmpo.c_str());
      buildFail();
      koko = match();
      if (koko > maxo) {
        maxo = koko;
        ans = tmpo;
      }
      tmpo = days[j] + "-" + months[i] + "-" + "2014";
      strcpy(p, tmpo.c_str());
      buildFail();
      koko = match();
      if (koko > maxo) {
        maxo = koko;
        ans = tmpo;
      }
      tmpo = days[j] + "-" + months[i] + "-" + "2015";
      strcpy(p, tmpo.c_str());
      buildFail();
      koko = match();
      if (koko > maxo) {
        maxo = koko;
        ans = tmpo;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
