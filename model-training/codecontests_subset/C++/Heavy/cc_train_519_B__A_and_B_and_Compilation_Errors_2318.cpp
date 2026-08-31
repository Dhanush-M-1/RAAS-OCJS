#include <bits/stdc++.h>
using namespace std;
map<int, int> cnt1, cnt2, cnt3;
int n;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    ++cnt1[x];
  }
  for (int i = 1; i <= n - 1; ++i) {
    int x;
    scanf("%d", &x);
    ++cnt2[x];
  }
  for (int i = 1; i <= n - 2; ++i) {
    int x;
    scanf("%d", &x);
    ++cnt3[x];
  }
  for (map<int, int>::iterator it = cnt1.begin(); it != cnt1.end(); ++it)
    if (it->second != cnt2[it->first]) {
      printf("%d\n", it->first);
      break;
    }
  for (map<int, int>::iterator it = cnt2.begin(); it != cnt2.end(); ++it)
    if (it->second != cnt3[it->first]) {
      printf("%d", it->first);
      break;
    }
  return 0;
}
