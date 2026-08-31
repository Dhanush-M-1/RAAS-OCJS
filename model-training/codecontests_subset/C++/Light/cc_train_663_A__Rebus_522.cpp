#include <bits/stdc++.h>
using namespace std;
template <class T>
int size(const T &x) {
  return x.size();
}
const int INF = 2147483647;
int main() {
  string s;
  int sign = 1;
  int add = 0, sub = 0;
  vector<int> parts;
  while (cin >> s) {
    if (sign == 1)
      add++;
    else
      sub++;
    parts.push_back(sign);
    cin >> s;
    if (s == "=") {
      break;
    }
    if (s == "+") {
      sign = 1;
    } else {
      sign = -1;
    }
  }
  int n;
  cin >> n;
  int left = n;
  vector<int> res;
  bool ok = true;
  for (__typeof(0) i = (0); i < (size(parts)); ++i) {
    int nadd = add, nsub = sub;
    if (parts[i] == 1)
      nadd--;
    else
      nsub--;
    bool found = false;
    for (int x = 1; x <= n; x++) {
      int nleft = parts[i] == 1 ? left - x : left + x;
      int mn = nadd * 1 - nsub * n, mx = nadd * n - nsub * 1;
      if (mn <= nleft && nleft <= mx) {
        res.push_back(x);
        left = nleft;
        found = true;
        break;
      }
    }
    if (!found) {
      ok = false;
      break;
    }
    add = nadd;
    sub = nsub;
  }
  if (!ok) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  for (__typeof(0) i = (0); i < (size(res)); ++i) {
    if (i != 0) {
      printf("%c ", parts[i] == 1 ? '+' : '-');
    }
    printf("%d ", res[i]);
  }
  printf("= %d\n", n);
  return 0;
}
