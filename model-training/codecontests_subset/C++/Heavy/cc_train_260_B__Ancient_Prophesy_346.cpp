#include <bits/stdc++.h>
using namespace std;
string str;
struct node {
  string tt;
  int c;
};
map<string, int> vis;
node nodes[1000008];
int cnt;
bool check(int dd, int mm) {
  if (dd <= 0) return false;
  if (mm <= 0) return false;
  if (mm == 2) {
    if (dd <= 28)
      return true;
    else
      return false;
  }
  if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 ||
      mm == 12) {
    if (dd <= 31)
      return true;
    else
      return false;
  }
  if (mm == 2 || mm == 4 || mm == 6 || mm == 9 || mm == 11) {
    if (dd <= 30)
      return true;
    else
      return false;
  }
  return false;
}
void findS(int s) {
  string tmp;
  int dd, yy, mm;
  if (s < 2) return;
  if (str[s - 1] >= '0' && str[s - 1] <= '9' && str[s - 2] <= '9' &&
      str[s - 2] >= '0') {
    dd = (int)(str[s - 2] - '0') * 10 + (int)(str[s - 1] - '0');
    if (str[s + 1] >= '0' && str[s + 1] <= '9' && str[s + 2] >= '0' &&
        str[s + 2] <= '9') {
      mm = (str[s + 1] - '0') * 10 + (str[s + 2] - '0');
      if (!check(dd, mm)) return;
      if (str[s + 3] != '-') return;
      if (str[s + 4] >= '0' && str[s + 4] <= '9' && str[s + 5] >= '0' &&
          str[s + 5] <= '9' && str[s + 6] >= '0' && str[s + 6] <= '9' &&
          str[s + 7] >= '0' && str[s + 7] <= '9')
        yy = (str[s + 4] - '0') * 1000 + (str[s + 5] - '0') * 100 +
             (str[s + 6] - '0') * 10 + str[s + 7] - '0';
      else
        return;
      if (yy < 2013 || yy > 2015) return;
      tmp.push_back(str[s - 2]);
      tmp.push_back(str[s - 1]);
      tmp.push_back(str[s + 1]);
      tmp.push_back(str[s + 2]);
      tmp.push_back(str[s + 4]);
      tmp.push_back(str[s + 5]);
      tmp.push_back(str[s + 6]);
      tmp.push_back(str[s + 7]);
      if (vis[tmp]) {
        nodes[vis[tmp]].c++;
      } else {
        vis[tmp] = ++cnt;
        nodes[vis[tmp]].c = 1;
        nodes[vis[tmp]].tt = tmp;
      }
    }
  }
}
bool cmp(node a, node b) { return a.c > b.c; }
int main() {
  cin >> str;
  vis.clear();
  cnt = 0;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '-') {
      findS(i);
    }
  }
  sort(nodes + 1, nodes + 1 + cnt, cmp);
  cout << nodes[1].tt[0] << nodes[1].tt[1] << "-" << nodes[1].tt[2]
       << nodes[1].tt[3] << "-" << nodes[1].tt[4] << nodes[1].tt[5]
       << nodes[1].tt[6] << nodes[1].tt[7] << endl;
  return 0;
}
