#include <bits/stdc++.h>
using namespace std;
const int MAXW = 5000000, MAXN = 1000010;
char buf[MAXW + 10];
vector<string> W;
int c[MAXN], sum[MAXN], last[20][MAXN];
int res[MAXN];
int main(void) {
  int n, R, C;
  scanf("%d%d%d", &n, &R, &C);
  W = vector<string>(n);
  for (int i = 0; i < (n); ++i) {
    scanf("%s", buf);
    W[i] = buf;
    c[i] = ((int)((W[i]).size()));
  }
  sum[0] = c[0];
  for (int i = (1); i < (n); ++i) {
    sum[i] = sum[i - 1] + c[i];
  }
  for (int i = 0; i < (n); ++i) {
    res[i] = -2;
  }
  for (int i = 0; i < (n); ++i) {
    int l = i, r = n - 1, best = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      int L = sum[mid] - (i == 0 ? 0 : sum[i - 1]) + (mid - i);
      if (L <= C) {
        best = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    last[0][i] = best;
  }
  for (int b = 1; (1 << b) <= R; ++b) {
    int w = b - 1;
    for (int i = 0; i < (n); ++i) {
      if (last[w][i] == -1 || last[w][i] == n - 1 ||
          last[w][last[w][i] + 1] == -1) {
        last[b][i] = -1;
      } else {
        last[b][i] = last[w][last[w][i] + 1];
      }
    }
  }
  for (int i = 0; i < (n); ++i) {
    if (last[0][i] == -1) {
      res[i] = -1;
    } else {
      res[i] = i;
    }
    int b, cur = i, rem = R;
    for (b = 0; (1 << b) <= R; ++b)
      ;
    for (--b; b >= 0; --b) {
      if ((1 << b) > rem) {
        continue;
      }
      if (cur < n && last[b][cur] != -1) {
        res[i] = last[b][cur];
        rem -= (1 << b);
        cur = last[b][cur] + 1;
      }
    }
  }
  int best = -1;
  for (int i = 0; i < (n); ++i) {
    if (res[i] == -1) {
      continue;
    }
    if (best == -1 || res[i] - i > res[best] - best) {
      best = i;
    }
  }
  if (best == -1) {
    return 0;
  }
  int cur = 0;
  for (int i = 0, j = 0; j < R && best + i < n; ++i) {
    int k = i + best;
    if (c[k] > C) {
      break;
    }
    if (cur + c[k] + (cur == 0 ? 0 : 1) <= C) {
      printf("%s%s", (cur == 0 ? "" : " "), W[k].c_str());
      cur += c[k] + (cur == 0 ? 0 : 1);
    } else {
      ++j;
      if (j == R) {
        break;
      }
      printf("\n%s", W[k].c_str());
      cur = c[k];
    }
  }
  puts("");
  return 0;
}
