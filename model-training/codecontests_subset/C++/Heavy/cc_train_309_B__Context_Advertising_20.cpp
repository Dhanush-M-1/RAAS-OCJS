#include <bits/stdc++.h>
using namespace std;
char buf[5 << 20];
vector<int> len;
vector<string> vs;
int skip[20][1 << 20];
int skipn(int n, int k) {
  for (int i = 0; i < 20; ++i) {
    if (((n >> i) & 1) != 0) {
      k = skip[i][k];
    }
  }
  return k;
}
int main() {
  int n, r, c;
  int from, to;
  scanf("%d%d%d", &n, &r, &c);
  for (int i = 0; i < n; ++i) {
    scanf("%s", buf);
    vs.push_back(buf);
    len.push_back(vs.back().size());
  }
  for (int i = 0, j = 0, k = 0; i < n; ++i) {
    if (j <= i) {
      j = i;
      k = 0;
    } else {
      k -= len[i - 1];
    }
    while (j < n && (k + len[j] + j - i) <= c) {
      k += len[j];
      ++j;
    }
    skip[0][i] = j;
  }
  skip[0][n] = n;
  for (int i = 1; i < 20; ++i) {
    for (int j = 0; j <= n; ++j) {
      skip[i][j] = skip[i - 1][skip[i - 1][j]];
    }
  }
  from = to = 0;
  for (int i = 0; i < n; ++i) {
    int j = skipn(r, i);
    if (j - i > to - from) {
      from = i;
      to = j;
    }
  }
  while (from < to) {
    for (int i = from; i < skip[0][from]; ++i) {
      printf("%s%s", i == from ? "" : " ", vs[i].c_str());
    }
    puts("");
    from = skip[0][from];
  }
  return 0;
}
