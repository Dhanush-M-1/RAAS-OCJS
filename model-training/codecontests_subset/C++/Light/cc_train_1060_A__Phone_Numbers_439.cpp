#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e2 + 10;
int n, m, rst;
int d[maxn][maxn];
int vis[maxn];
int main() {
  int n;
  scanf("%d", &n);
  if (n < 11) {
    cout << '0' << endl;
    return 0;
  }
  string str;
  cin >> str;
  int cnt = 0;
  for (int i = 0; i < str.size(); i++) {
    vis[str[i] - '0']++;
  }
  while (vis[8]) {
    vis[8]--;
    n--;
    if (n >= 10) cnt++, n -= 10;
  }
  printf("%d\n", cnt);
  return 0;
}
