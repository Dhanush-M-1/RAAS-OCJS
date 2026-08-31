#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return a % b == 0 ? b : gcd(b, a % b); }
int cnt[30];
char s[1010];
const int MAXN = 1010;
vector<int> ans;
int main() {
  int K;
  while (cin >> K >> s) {
    memset(cnt, 0, sizeof(cnt));
    int len = strlen(s);
    for (int i = 0; i < len; i++) cnt[s[i] - 'a']++;
    bool flag = false;
    for (int i = 0; i < 26; i++) {
      if (cnt[i] == 0) continue;
      if (cnt[i] >= K && cnt[i] % K == 0)
        continue;
      else
        flag = true;
    }
    if (flag)
      puts("-1");
    else {
      int tot = 0;
      char tmp[MAXN];
      int leap = 0;
      while (tot < len) {
        for (int i = leap; i < 26; i++) {
          if (cnt[i]) {
            for (int j = 0; j < cnt[i] / K; j++) tmp[tot++] = i + 'a';
          }
        }
        leap = 0;
      }
      tmp[tot] = '\0';
      printf("%s\n", tmp);
    }
  }
  return 0;
}
