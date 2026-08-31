#include <bits/stdc++.h>
using namespace std;
int ans[6][20];
int a[20];
long long num;
int pos;
int luck[3] = {0, 4, 7};
int cnt = 0;
int use_num[3][400];
void prev() {
  cnt = 0;
  for (int i = 0; i <= 6; i++) {
    for (int j = 0; j + i <= 6; j++) {
      use_num[0][cnt] = i;
      use_num[1][cnt] = j;
      use_num[2][cnt] = 6 - i - j;
      cnt++;
    }
  }
}
void init() {
  pos = 0;
  while (num > 0) {
    a[pos++] = num % 10;
    num = num / 10;
  }
  memset(ans, 0, sizeof(ans));
}
bool dfs(int deep, int nu, int sum) {
  if (nu >= cnt) return false;
  if (deep == pos && sum == 0) return true;
  if (deep == pos) return false;
  int tot = sum;
  for (int i = 0; i < 3; i++) tot += use_num[i][nu] * luck[i];
  int t = 0;
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < use_num[i][nu]; j++) ans[t++][deep] = luck[i];
  }
  if (tot % 10 == a[deep])
    if (dfs(deep + 1, 0, tot / 10)) return true;
  return dfs(deep, nu + 1, sum);
}
int main() {
  prev();
  int n;
  scanf("%d", &n);
  for (int T = 0; T < n; T++) {
    scanf("%I64d", &num);
    init();
    if (dfs(0, 0, 0)) {
      for (int i = 0; i < 6; i++) {
        string S = "";
        for (int j = 0; j < 20; j++) {
          S += (char)('0' + ans[i][j]);
        }
        reverse(S.begin(), S.end());
        int pp = 0;
        while (pp < S.length() - 1 && S[pp] == '0') pp++;
        string res = S.substr(pp);
        cout << res << " ";
      }
      cout << endl;
    } else
      printf("-1\n");
  }
  return 0;
}
