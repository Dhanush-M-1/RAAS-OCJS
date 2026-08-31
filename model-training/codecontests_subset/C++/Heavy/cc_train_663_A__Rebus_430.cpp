#include <bits/stdc++.h>
using namespace std;
int n, neg = 0;
char s[1009];
int main() {
  vector<int> ans;
  scanf("%[^=]=%d", s, &n);
  ans.push_back(n);
  for (int i = 1; s[i]; i++) {
    if (s[i] == ' ') continue;
    if (s[i] == '-')
      neg = 1;
    else if (s[i] == '+')
      neg = 0;
    else if (s[i] == '?' && !neg) {
      ans[0] -= 1;
      ans.push_back(1);
    } else if (s[i] == '?') {
      int c = 0;
      ans[0] += 1;
      ans.push_back(-1);
    }
  }
  int c = 1;
  while (ans[0] > n && c < ans.size()) {
    if (ans[c] > 0 && ans[c] < n) {
      ans[0]--;
      ans[c]++;
    } else
      c++;
  }
  c = 1;
  while (ans[0] <= 0 && c < ans.size()) {
    if (ans[c] < 0 && abs(ans[c]) < n) {
      ans[0]++;
      ans[c]--;
    } else
      c++;
  }
  if (ans[0] <= 0 || ans[0] > n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  printf("%d", ans[0]);
  for (int i = 1; i < ans.size(); i++) {
    if (ans[i] > 0)
      printf(" + %d", ans[i]);
    else
      printf(" - %d", abs(ans[i]));
  }
  printf(" = %d\n", n);
  return 0;
}
