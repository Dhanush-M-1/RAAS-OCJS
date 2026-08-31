#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3e5 + 5;
char ch[MAXN];
int num[999];
int vis[999];
int n, m, t;
int match(int l, int r) {
  for (int i = 0; i <= r - l; i++) {
    if (ch[l + i] < ch[r - i]) return 0;
    if (ch[l + i] > ch[r - i]) return 1;
  }
  return 0;
}
int main() {
  memset(num, 0x3f, sizeof num);
  cin >> n;
  cin >> ch + 1;
  int len = strlen(ch + 1);
  for (int i = 1; i <= n; i++) {
    char xiao = ch[i];
    for (int j = 1; j <= 26; j++) {
      if (xiao < 'a' + j - 1 && vis[j + 'a' - 1]) {
        cout << "YES" << endl << num[j + 'a' - 1] << ' ' << i;
        return 0;
      }
    }
    num[ch[i]] = i;
    vis[ch[i]] = 1;
  }
  cout << "NO";
  return 0;
}
