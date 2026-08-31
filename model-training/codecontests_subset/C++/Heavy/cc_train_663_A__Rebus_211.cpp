#include <bits/stdc++.h>
using namespace std;
int i, ans[1000005], ans1[1000005];
char s[1000005];
vector<int> add, minu;
int main() {
  gets(s);
  int l = strlen(s);
  int val = 0;
  add.push_back(0);
  for (i = 0; i < l; i++) {
    if (s[i] == '+')
      add.push_back(i);
    else if (s[i] == '-')
      minu.push_back(i);
    else if (s[i] >= '0' && s[i] <= '9') {
      val = val * 10 + (s[i] - '0');
    }
  }
  if (add.size() * val < val + minu.size()) return 0 * printf("Impossible\n");
  int tot = val + minu.size() - add.size();
  int extra = 0;
  if (tot < 0) {
    extra = -tot;
    tot = 0;
    if (extra > (long long)minu.size() * (val - 1))
      return 0 * printf("Impossible\n");
  }
  for (i = 0; i < add.size(); i++) {
    int now = min(tot, val - 1);
    ans[i] = now + 1;
    tot -= now;
  }
  for (i = 0; i < minu.size(); i++) {
    int now = min(extra, val - 1);
    extra -= now;
    ans1[i] = now + 1;
  }
  int p = 0;
  int p1 = 0;
  int cnt = 0;
  printf("Possible\n");
  printf("%d", ans[p++]);
  for (i = 0; i < l; i++) {
    if (s[i] == '+') {
      printf(" %c %d", s[i], ans[p++]);
    } else if (s[i] == '-') {
      printf(" %c %d", s[i], ans1[p1++]);
    }
  }
  printf(" = %d", val);
  printf("\n");
}
