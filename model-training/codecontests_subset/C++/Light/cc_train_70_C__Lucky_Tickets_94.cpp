#include <bits/stdc++.h>
using namespace std;
int tree[200010], rever[100010];
int maxa, maxb, w;
map<long double, vector<int> > st;
int sum(int x) {
  int ans = 0;
  while (x > 0) {
    ans += tree[x];
    x -= x & -x;
  }
  return ans;
}
void add(int x, int a) {
  while (x <= maxb) {
    tree[x] += a;
    x += x & -x;
  }
}
int rev(int a) {
  char str[10] = {0};
  sprintf(str, "%d", a);
  reverse(str, strlen(str) + str);
  sscanf(str, "%d", &a);
  return a;
}
int main() {
  int lst = 100000, mx, my;
  long long ans = 1000000000000ll;
  scanf("%d%d%d", &maxa, &maxb, &w);
  for (int i = 1; i <= maxb; ++i)
    st[(long double)rev(i) / (long double)i].push_back(i);
  for (int i = 1; i <= ((maxa) < (maxb) ? (maxb) : (maxa)); ++i)
    rever[i] = rev(i);
  for (int a = 1; a <= maxa; ++a) {
    int reva = rever[a];
    if (a % 9 != reva % 9) continue;
    if (st.find((long double)a / (long double)reva) == st.end()) continue;
    vector<int>& vec = st[(long double)a / (long double)reva];
    for (int i = 0; i < vec.size() && vec[i] < lst; ++i)
      if (vec[i] * a == rever[vec[i]] * reva) add(vec[i], 1);
    if (sum(maxb) < w) continue;
    int l = 0, r = maxb;
    while (l < r) {
      int ans = (l + r) >> 1;
      if (sum(ans) >= w)
        r = ans;
      else
        l = ans + 1;
    }
    lst = l;
    if (ans > l * (long long)a) ans = l * (long long)a, mx = a, my = l;
  }
  if (ans < 1000000000000ll)
    printf("%d %d", mx, my);
  else
    printf("-1");
}
