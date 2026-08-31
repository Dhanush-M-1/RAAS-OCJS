#include <bits/stdc++.h>
using namespace std;
int m, n, a[100][100], DP, CP;
struct P {
  int x, y;
} BP;
void change_CP() { CP = abs(CP - 1); }
void change_DP() { DP = (DP + 1) % 4; }
void move() {
  int tmp = a[BP.x][BP.y];
  if (DP == 0) {
    if (!CP) {
      while (a[BP.x][BP.y + 1] == tmp) BP.y++;
      while (a[BP.x - 1][BP.y] == tmp) BP.x--;
    } else {
      while (a[BP.x][BP.y + 1] == tmp) BP.y++;
      while (a[BP.x + 1][BP.y] == tmp) BP.x++;
    }
    if (a[BP.x][BP.y + 1]) {
      BP.y++;
      return;
    }
  } else if (DP == 1) {
    if (!CP) {
      while (a[BP.x + 1][BP.y] == tmp) BP.x++;
      while (a[BP.x][BP.y + 1] == tmp) BP.y++;
    } else {
      while (a[BP.x + 1][BP.y] == tmp) BP.x++;
      while (a[BP.x][BP.y - 1] == tmp) BP.y--;
    }
    if (a[BP.x + 1][BP.y]) {
      BP.x++;
      return;
    }
  } else if (DP == 2) {
    if (!CP) {
      while (a[BP.x][BP.y - 1] == tmp) BP.y--;
      while (a[BP.x + 1][BP.y] == tmp) BP.x++;
    } else {
      while (a[BP.x][BP.y - 1] == tmp) BP.y--;
      while (a[BP.x - 1][BP.y] == tmp) BP.x--;
    }
    if (a[BP.x][BP.y - 1]) {
      BP.y--;
      return;
    }
  } else if (DP == 3) {
    if (!CP) {
      while (a[BP.x - 1][BP.y] == tmp) BP.x--;
      while (a[BP.x][BP.y - 1] == tmp) BP.y--;
    } else {
      while (a[BP.x - 1][BP.y] == tmp) BP.x--;
      while (a[BP.x][BP.y + 1] == tmp) BP.y++;
    }
    if (a[BP.x - 1][BP.y]) {
      BP.x--;
      return;
    }
  }
  if (!CP) {
    change_CP();
  } else {
    change_CP();
    change_DP();
  }
}
int main() {
  cin >> m >> n;
  string s;
  for (int i = 1; i <= m; i++) {
    cin >> s;
    for (int j = 0; j < s.length(); j++) {
      a[i][j + 1] = s[j] - '0';
    }
  }
  BP.x = 1;
  BP.y = 1;
  while (n) {
    move();
    n--;
  }
  cout << a[BP.x][BP.y];
  return 0;
}
