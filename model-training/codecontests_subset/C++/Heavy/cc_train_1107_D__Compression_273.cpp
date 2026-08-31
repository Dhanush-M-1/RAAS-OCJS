#include <bits/stdc++.h>
using namespace std;
int gra[5210][5210];
int n;
char row[5210][5210];
int B[5210][5210];
map<char, int> mp;
vector<int> V;
bool check(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      for (int k = i; k < i + x; k++) {
        for (int t = j; t < j + x; t++) {
          if (gra[k][t] != gra[i][j]) return false;
        }
      }
    }
  }
  return true;
}
int main(void) {
  cin >> n;
  mp['A'] = 10, mp['B'] = 11, mp['C'] = 12, mp['D'] = 13, mp['E'] = 14,
  mp['F'] = 15;
  for (int i = 1; i <= n; i++) {
    cin >> row[i];
  }
  for (int i = 1; i <= n; i++) {
    int len = strlen(row[i]);
    for (int j = 0; j < len; j++) {
      char x = row[i][j];
      int num;
      if (isdigit(x))
        num = x - '0';
      else
        num = mp[x];
      for (int k = 3; k >= 0; k--) {
        if (num & (1 << k)) {
          gra[i][4 * j + (4 - k)] = 1;
        } else {
          gra[i][4 * j + (4 - k)] = 0;
        }
      }
    }
  }
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      V.push_back(i);
      if (i * i != n) V.push_back(n / i);
    }
  }
  sort(V.begin(), V.end());
  for (int i = V.size() - 1; i >= 0; i--) {
    int cut = V[i];
    if (check(cut)) {
      cout << cut << endl;
      break;
    }
  }
  return 0;
}
