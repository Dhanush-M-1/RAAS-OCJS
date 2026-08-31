#include <bits/stdc++.h>
using namespace std;
struct node {
  long long sumlow;
  long long sumhigh;
};
const int BT = 262144;
node itree[BT * 2];
int orders[BT];
int a, b;
void updatetree(int pos, int val) {
  pos += BT;
  itree[pos].sumlow = min(b, val);
  itree[pos].sumhigh = min(a, val);
  pos >>= 1;
  while (pos >= 1) {
    itree[pos].sumlow = itree[(pos << 1)].sumlow + itree[(pos << 1) + 1].sumlow;
    itree[pos].sumhigh =
        itree[(pos << 1)].sumhigh + itree[(pos << 1) + 1].sumhigh;
    pos >>= 1;
  }
}
long long getrangelow(int l, int r) {
  long long ans = 0;
  l += BT, r += BT;
  while (l <= r) {
    if (l & 1) {
      ans += itree[l].sumlow;
    }
    if (!(r & 1)) {
      ans += itree[r].sumlow;
    }
    l = (l + 1) >> 1;
    r = (r - 1) >> 1;
  }
  return ans;
}
long long getrangehigh(int l, int r) {
  long long ans = 0;
  l += BT, r += BT;
  while (l <= r) {
    if (l & 1) {
      ans += itree[l].sumhigh;
    }
    if (!(r & 1)) {
      ans += itree[r].sumhigh;
    }
    l = (l + 1) >> 1;
    r = (r - 1) >> 1;
  }
  return ans;
}
int main() {
  int n, K, q;
  scanf("%d%d%d%d%d", &n, &K, &a, &b, &q);
  for (int i = 0; i < q; i++) {
    int cmdtype;
    scanf("%d", &cmdtype);
    if (cmdtype == 1) {
      int day, add;
      scanf("%d%d", &day, &add);
      orders[day] += add;
      updatetree(day, orders[day]);
    } else {
      int pend;
      scanf("%d", &pend);
      long long a1 = getrangelow(0, pend - 1);
      long long a2 = getrangehigh(pend + K, BT - 1);
      printf("%lld\n", a1 + a2);
    }
  }
  return 0;
}
