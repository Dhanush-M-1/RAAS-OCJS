#include <bits/stdc++.h>
using namespace std;
int rsp[20];
long long ls[20][50];
long long maxi[20];
int cnt = 0;
bool func(long long x, int i) {
  if (i == 0) {
    for (int j = 0; j < cnt; j++) {
      if (x == ls[i][j]) {
        rsp[i] = j;
        return true;
      }
    }
  } else {
    for (int j = 0; j < cnt; j++) {
      if (x - ls[i][j] >= 0 && x - ls[i][j] <= maxi[i - 1]) {
        rsp[i] = j;
        if (func(x - ls[i][j], i - 1)) return true;
      }
    }
  }
  return false;
}
pair<int, pair<int, int> > ls2[50];
long long g[10];
int main() {
  for (int i = 0; i < 7; i++)
    for (int j = 0; j < 7 - i; j++) {
      ls2[cnt++] = make_pair(i * 4 + j * 7, make_pair(i, j));
    }
  sort(ls2, ls2 + cnt);
  for (int i = 0; i < cnt; i++) ls[0][i] = ls2[i].first;
  for (int i = 1; i < 18; i++) {
    for (int j = 0; j < cnt; j++) {
      ls[i][j] = ls[i - 1][j] * 10LL;
    }
  }
  maxi[0] = ls[0][cnt - 1];
  for (int i = 1; i < 18; i++) {
    maxi[i] = maxi[i - 1] + ls[i][cnt - 1];
  }
  int cas;
  scanf("%d", &cas);
  for (int u = 0; u < cas; u++) {
    long long v;
    scanf("%lld", &v);
    if (func(v, 17)) {
      for (int i = 0; i < 6; i++) g[i] = 0;
      for (int i = 0; i < 18; i++) {
        int k7 = ls2[rsp[i]].second.second;
        int k4 = ls2[rsp[i]].second.first;
        for (int j = 0; j < k7; j++) g[j] += ls[i][2];
        for (int j = k7; j < k7 + k4; j++) g[j] += ls[i][1];
      }
      for (int i = 0; i < 6; i++) {
        if (i) printf(" ");
        printf("%lld", g[i]);
      }
      printf("\n");
    } else
      printf("-1\n");
  }
  return 0;
}
