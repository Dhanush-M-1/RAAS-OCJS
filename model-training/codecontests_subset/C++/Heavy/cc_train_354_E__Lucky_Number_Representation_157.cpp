#include <bits/stdc++.h>
using namespace std;
long long f[100];
long long base[20];
struct NODE {
  int a, i4, i7;
  NODE(int i, int j) {
    i4 = i;
    i7 = j;
    a = i4 * 4 + i7 * 7;
  };
  bool operator<(const NODE &x) const { return a < x.a; };
};
vector<NODE> v;
int way[100];
bool dfs(long long remain, int a) {
  if (a == 0) {
    if ((remain == 0)) return true;
    return false;
  }
  if (remain > f[a]) return false;
  for (int i = 0; i < v.size(); ++i) {
    if (remain < v[i].a * base[a]) break;
    way[a] = i;
    if (dfs(remain - v[i].a * base[a], a - 1)) return true;
  }
  return false;
}
void gao(long long x) {
  if (!dfs(x, 18)) {
    printf("-1\n");
    return;
  }
  long long ret[10] = {0};
  for (int i = 1, now = 0; i <= 18; ++i) {
    int k = way[i];
    for (int j = 0; j < v[k].i4; ++j) {
      ret[now] += base[i] * 4;
      now = (now + 1) % 6;
    }
    for (int j = 0; j < v[k].i7; ++j) {
      ret[now] += base[i] * 7;
      now = (now + 1) % 6;
    }
  }
  for (int i = 0; i < 6; ++i) cout << ret[i] << ((i == 5) ? '\n' : ' ');
}
int main() {
  int n;
  for (int i = 0; i <= 6; ++i)
    for (int j = 0; j + i <= 6; ++j) v.push_back(NODE(i, j));
  sort(v.begin(), v.end());
  for (int i = 1; i <= 18; ++i) {
    f[i] = f[i - 1] * 10 + 42;
    if (i == 1)
      base[i] = 1;
    else
      base[i] = base[i - 1] * 10;
  }
  int t;
  while (cin >> t) {
    for (int i = 0; i < t; ++i) {
      long long x;
      cin >> x;
      gao(x);
    }
  }
}
