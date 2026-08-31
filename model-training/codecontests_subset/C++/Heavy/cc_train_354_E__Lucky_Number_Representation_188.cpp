#include <bits/stdc++.h>
using namespace std;
int t;
bool vis[20][10];
vector<int> v;
int l;
long long n;
vector<int> ans[6];
void add(int s, int f) {
  for (int i = 0; i < 6; ++i) ans[i].push_back(0);
  for (int i = 0; i < s; ++i) ans[i].back() += 7;
  for (int i = s; i < s + f; ++i) ans[i].back() += 4;
}
void print() {
  for (int i = 0; i < 6; ++i) {
    long long x = 0;
    for (int j = ans[i].size() - 1; j >= 0; --j) x = (x * 10) + ans[i][j];
    printf("%I64d ", x);
  }
  printf("\n");
}
bool check(int i, int ex) {
  if (vis[i][ex]) return false;
  vis[i][ex] = true;
  if (i == 0) {
    for (int s = 0; s <= 6; ++s)
      for (int f = 0; s + f <= 6; ++f) {
        int num = (s * 7) + (f * 4);
        if (num % 10 == v[0] && num / 10 == ex) {
          add(s, f);
          return true;
        }
      }
    return false;
  }
  for (int s = 0; s <= 6; ++s)
    for (int f = 0; s + f <= 6; ++f) {
      for (int prev = 0; prev <= 9; ++prev) {
        int num = (s * 7) + (f * 4) + prev;
        if (num % 10 == v[i] && num / 10 == ex) {
          bool x = check(i - 1, prev);
          if (x) {
            add(s, f);
            return true;
          }
        }
      }
    }
  return false;
}
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%I64d", &n);
    memset(vis, 0, sizeof vis);
    for (int i = 0; i < 6; ++i) ans[i].clear();
    v.clear();
    long long x = n;
    while (x) {
      v.push_back(x % 10);
      x /= 10;
    }
    l = v.size();
    x = false;
    x = check(l - 1, 0);
    if (x) {
      print();
      continue;
    }
    if (l >= 2) {
      x = check(l - 2, v[l - 1]);
      if (x) {
        print();
        continue;
      }
    }
    puts("-1");
  }
  return 0;
}
