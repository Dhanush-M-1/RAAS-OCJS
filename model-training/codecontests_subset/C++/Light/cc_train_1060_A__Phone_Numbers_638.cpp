#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  string str;
  cin >> str;
  int cnt[10];
  memset(cnt, 0, sizeof cnt);
  for (int i = 0; i < str.length(); i++) {
    int p = str[i] - '0';
    cnt[p]++;
  }
  int maxs = 0;
  for (int i = 0; i <= cnt[8]; i++) {
    int oth = i * 10;
    int baki = n - i;
    if (baki >= oth) maxs = max(maxs, i);
  }
  cout << maxs;
}
