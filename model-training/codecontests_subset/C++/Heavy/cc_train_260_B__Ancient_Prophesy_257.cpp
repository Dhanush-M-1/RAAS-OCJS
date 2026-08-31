#include <bits/stdc++.h>
using namespace std;
string a;
int h1[100][100][10];
int moth[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool panduan[10] = {0, 0, 1, 0, 0, 1};
bool pan(string m) {
  string h(m, 6, 4);
  if (h != "2013" && h != "2014" && h != "2015") return 0;
  int u = (m[0] - '0') * 10 + m[1] - '0', v = (m[3] - '0') * 10 + m[4] - '0',
      z = m[9] - '0';
  if ((0 < v && v <= 12 && u > 0 && u <= moth[v]) == 0) return 0;
  for (int i = 0; i < 10; i++)
    if (panduan[i] != (m[i] == '-')) return 0;
  h1[u][v][z]++;
  return 1;
}
string huanyuan(int i, int j, int o) {
  string u = "";
  u += char(i / 10 + int('0'));
  u += char(i % 10 + int('0'));
  u += '-';
  u += char(j / 10 + int('0'));
  u += char(j % 10 + int('0'));
  u += '-';
  u += "201";
  u += char(o + int('0'));
  return u;
}
int main(int argc, char *argv[]) {
  cin >> a;
  for (int i = 0; i <= a.size() - 10; i++) {
    string m(a, i, 10);
    pan(m);
  }
  string e;
  int u = 0;
  for (int i = 0; i < 40; i++) {
    for (int j = 0; j < 20; j++) {
      for (int o = 0; o < 10; o++) {
        if (h1[i][j][o] > u) {
          u = h1[i][j][o];
          e = huanyuan(i, j, o);
        }
      }
    }
  }
  cout << e << endl;
  return 0;
}
