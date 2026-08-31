#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[3];
  int cnt1 = 1, cnt2 = 0, n;
  vector<int> vec, v1, v2;
  while (true) {
    scanf("%s", s);
    if (s[0] == '+')
      ++cnt1, vec.push_back(1);
    else if (s[0] == '-')
      ++cnt2, vec.push_back(-1);
    else if (s[0] == '=') {
      scanf("%d", &n);
      break;
    }
  }
  int l1 = cnt1, r1 = cnt1 * n, l2 = cnt2 + n, r2 = cnt2 * n + n;
  if (l2 > r1 || l1 > r2) return 0 * puts("Impossible");
  puts("Possible");
  int sum;
  if (l2 >= l1 && l2 <= r1)
    sum = l2;
  else
    sum = l1;
  for (int i = 0; i < cnt1; ++i) v1.push_back(1);
  int x = sum - cnt1;
  for (int i = 0; i < cnt1; ++i) {
    int add = min(n - 1, x);
    x -= add, v1[i] += add;
    if (!x) break;
  }
  sum = sum - n;
  for (int i = 0; i < cnt2; ++i) v2.push_back(1);
  x = sum - cnt2;
  for (int i = 0; i < cnt2; ++i) {
    int add = min(n - 1, x);
    x -= add, v2[i] += add;
    if (!x) break;
  }
  int now1 = 0, now2 = 0;
  printf("%d ", v1[now1++]);
  for (int i = 0; i < (int)vec.size(); ++i) {
    if (vec[i] == 1)
      printf("%c %d ", '+', v1[now1++]);
    else if (vec[i] == -1)
      printf("%c %d ", '-', v2[now2++]);
  }
  printf("%c %d\n", '=', n);
  return 0;
}
