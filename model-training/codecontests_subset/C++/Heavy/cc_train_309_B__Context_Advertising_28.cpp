#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:64000000")
const int MAXN = 1000002;
int n, R, C;
int a[MAXN];
int s[MAXN];
int b[MAXN];
vector<string> words;
int d[MAXN][22];
inline int get_sum(int l, int r) {
  int res = s[r];
  if (l) res -= s[l - 1];
  return res;
}
inline void init() {
  cin >> n >> R >> C;
  words.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> words[i];
    a[i] = (int)words[i].length();
  }
  s[0] = a[0];
  for (int i = 1; i < n; ++i) s[i] = s[i - 1] + a[i];
}
inline int find(int x) {
  if (a[x] > C) return 0;
  int res = x;
  int l = x + 1, r = n - 1;
  while (l <= r) {
    int mid = (l + r) >> 1;
    if (get_sum(x, mid) + mid - x <= C) {
      res = mid;
      l = mid + 1;
    } else
      r = mid - 1;
  }
  return res - x + 1;
}
inline int get(int x, int r) {
  for (int z = 21; z >= 0; --z) {
    if ((1 << z) <= r) {
      r -= (1 << z);
      x = d[x][z];
    }
  }
  return x;
}
int main() {
  init();
  for (int i = 0; i < n; ++i) b[i] = find(i);
  for (int i = 0; i < n; ++i) {
    d[i][0] = i + b[i];
  }
  d[n][0] = n;
  for (int z = 1; z < 22; ++z) {
    for (int x = 0; x <= n; ++x) {
      int y = d[x][z - 1];
      d[x][z] = d[y][z - 1];
    }
  }
  int best = -1;
  int mx = -1;
  for (int i = 0; i < n; ++i) {
    int cur = get(i, R) - i;
    if (cur > mx) {
      mx = cur;
      best = i;
    }
  }
  if (best == -1) return 0;
  int x = best;
  int step = 0;
  while (x < n) {
    int last = d[x][0];
    if (x == last) break;
    ++step;
    cout << words[x];
    for (int i = x + 1; i < last; ++i) {
      cout << " " << words[i];
    }
    cout << endl;
    x = last;
    if (step == R) break;
  }
  return 0;
}
