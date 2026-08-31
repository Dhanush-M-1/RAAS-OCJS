#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 5;
struct st {
  int t, a, b;
};
deque<st> v, al, bo, ne;
int n, k;
st st1;
bool cmp(st stx, st sty) {
  if (stx.a + stx.b > sty.a + sty.b)
    return 1;
  else if (stx.a + stx.b < sty.a + sty.b)
    return 0;
  else
    return (stx.t < sty.t);
}
int main() {
  scanf("%d %d", &n, &k);
  while (n--) {
    scanf("%d %d %d", &st1.t, &st1.a, &st1.b);
    if (st1.a && st1.b)
      v.push_back(st1);
    else if (st1.a)
      al.push_back(st1);
    else if (st1.b)
      bo.push_back(st1);
  }
  sort(v.begin(), v.end(), cmp);
  sort(al.begin(), al.end(), cmp);
  sort(bo.begin(), bo.end(), cmp);
  int kx = 0, total = 0;
  while (kx < k) {
    if ((!v.empty() && !al.empty() && !bo.empty()) &&
        al.begin()->t + bo.begin()->t < v.begin()->t) {
      total += al.begin()->t + bo.begin()->t;
      kx++;
      al.pop_front();
      bo.pop_front();
    } else if (!v.empty()) {
      total += v.begin()->t;
      kx++;
      v.pop_front();
    } else if (!al.empty() && !bo.empty()) {
      total += al.begin()->t + bo.begin()->t;
      kx++;
      al.pop_front();
      bo.pop_front();
    } else
      break;
  }
  if (k == kx)
    cout << total;
  else
    cout << -1;
  return 0;
}
