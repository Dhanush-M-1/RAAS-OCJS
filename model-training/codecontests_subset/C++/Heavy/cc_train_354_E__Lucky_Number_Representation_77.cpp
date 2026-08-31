#include <bits/stdc++.h>
using namespace std;
struct num {
  int nd;
  int d[23];
  num() {
    nd = 0;
    memset(d, 0, sizeof d);
  }
  num(long long first) {
    nd = 0;
    memset(d, 0, sizeof d);
    if (first == 0LL) {
      nd = 1;
      d[nd - 1] = 0;
    }
    while (first > 0LL) {
      nd++;
      d[nd - 1] = first % 10;
      first = first / 10;
    }
  }
  int operator[](const int &i) const {
    if (i > nd) return (0);
    return (d[i - 1]);
  }
  void add(const int &i) {
    nd++;
    d[nd - 1] = i;
  }
  void print(void) {
    int i;
    long long val = 0LL;
    for (i = 0; i < nd; i = i + 1) val = val * 10LL + d[i];
    printf("%I64d", val);
  }
};
const int digit[] = {0, 4, 7};
int ndg;
long long n;
num tmp;
num ans[7];
bool vst[23][9];
pair<vector<int>, pair<int, int> > t[23][9];
void init(void) {
  scanf("%I64d", &n);
  tmp = num(n);
  ndg = tmp.nd;
  memset(vst, false, sizeof vst);
  int i;
  for (i = 0; i < 6; i = i + 1) ans[i].nd = 0;
}
void BFS(void) {
  queue<pair<int, int> > q;
  while (!q.empty()) q.pop();
  pair<int, int> p;
  int i1, i2, i3, i4, i5, i6;
  int pd, pr;
  vst[0][0] = true;
  q.push(pair<int, int>(0, 0));
  while (!q.empty()) {
    p = q.front();
    q.pop();
    pd = p.first;
    pr = p.second;
    if (pd == ndg && pr == 0) return;
    if (pd == ndg) continue;
    for (i1 = 0; i1 < 3; i1++)
      for (i2 = i1; i2 < 3; i2++)
        for (i3 = i2; i3 < 3; i3++)
          for (i4 = i3; i4 < 3; i4++)
            for (i5 = i4; i5 < 3; i5++)
              for (i6 = i5; i6 < 3; i6++)
                if ((digit[i1] + digit[i2] + digit[i3] + digit[i4] + digit[i5] +
                     digit[i6] + pr) %
                        10 ==
                    tmp[pd + 1])
                  if (!vst[pd + 1][(digit[i1] + digit[i2] + digit[i3] +
                                    digit[i4] + digit[i5] + digit[i6] + pr) /
                                   10]) {
                    vst[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                                 digit[i5] + digit[i6] + pr) /
                                10] = true;
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.clear();
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.push_back(i1);
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.push_back(i2);
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.push_back(i3);
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.push_back(i4);
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.push_back(i5);
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .first.push_back(i6);
                    t[pd + 1][(digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                               digit[i5] + digit[i6] + pr) /
                              10]
                        .second = p;
                    q.push(pair<int, int>(
                        pd + 1, (digit[i1] + digit[i2] + digit[i3] + digit[i4] +
                                 digit[i5] + digit[i6] + pr) /
                                    10));
                  }
  }
}
void trace(void) {
  if (!vst[ndg][0]) {
    printf("-1\n");
    return;
  }
  pair<int, int> cur = pair<int, int>(ndg, 0);
  int cd, cr, i;
  while (cur != pair<int, int>(0, 0)) {
    cd = cur.first;
    cr = cur.second;
    for (i = 0; i < 6; i = i + 1) ans[i].add(digit[t[cd][cr].first[i]]);
    cur = t[cd][cr].second;
  }
  for (i = 0; i < 6; i = i + 1) {
    ans[i].print();
    if (i < 5)
      printf(" ");
    else
      printf("\n");
  }
}
int main(void) {
  int t, ct;
  scanf("%d", &t);
  for (ct = 0; ct < t; ct++) {
    init();
    BFS();
    trace();
  }
  return 0;
}
