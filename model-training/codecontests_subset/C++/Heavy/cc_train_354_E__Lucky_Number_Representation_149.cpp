#include <bits/stdc++.h>
using namespace std;
const int d[3] = {0, 4, 7};
set<int> ss;
bool flag[60];
vector<int> v[60], tmp, ans;
int t;
char n[30];
set<int> a[30];
void dfs(int k, int s) {
  if (k == 6) {
    ss.insert(s);
    v[s] = tmp;
  } else {
    tmp.push_back(0);
    dfs(k + 1, s);
    tmp.pop_back();
    tmp.push_back(4);
    dfs(k + 1, s + 4);
    tmp.pop_back();
    tmp.push_back(7);
    dfs(k + 1, s + 7);
    tmp.pop_back();
  }
}
void dfs2(int k, int md) {
  if (k == 0) {
    ans.push_back(*a[0].begin() - md);
    return;
  }
  for (set<int>::iterator ai = a[k].begin(); ai != a[k].end(); ai++) {
    int kk = *ai;
    if (flag[kk - md]) {
      ans.push_back(kk - md);
      dfs2(k - 1, kk / 10);
      return;
    }
  }
}
int main() {
  tmp.clear();
  dfs(0, 0);
  memset(flag, false, sizeof(flag));
  for (set<int>::iterator si = ss.begin(); si != ss.end(); si++) {
    flag[*si] = true;
  }
  scanf("%d", &t);
  int ca = 0;
  while (t--) {
    int len = 0;
    scanf("%s", n);
    len = strlen(n);
    for (int i = 0; i < 20; i++) a[i].clear();
    a[0].insert(n[0] - '0');
    for (int i = 1; i < len; i++)
      for (set<int>::iterator ai = a[i - 1].begin(); ai != a[i - 1].end();
           ai++) {
        int k = *ai;
        for (int j = 0; j <= 4; j++)
          if (k >= j && flag[k - j]) a[i].insert(j * 10 + n[i] - '0');
      }
    int pass = -1;
    for (set<int>::iterator ai = a[len - 1].begin(); ai != a[len - 1].end();
         ai++)
      if (flag[*ai]) pass = *ai;
    if (pass == -1)
      puts("-1");
    else {
      ans.clear();
      dfs2(len - 1, 0);
      for (int k = 0; k < 6; k++) {
        long long X = 0;
        for (int i = ans.size() - 1; i >= 0; i--) X = X * 10 + v[ans[i]][k];
        printf("%I64d", X);
        if (k < 5) printf(" ");
      }
      puts("");
    }
  }
  return 0;
}
