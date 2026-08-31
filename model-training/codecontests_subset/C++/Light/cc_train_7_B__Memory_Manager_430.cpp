#include <bits/stdc++.h>
using namespace std;
int l[101], r[101], n, x, t, cnt;
bool a[101], al[101];
bool canput(int l, int r) {
  for (int i = l; i <= r; i++) {
    if (a[i]) return 0;
  }
  return 1;
}
void alloc() {
  cin >> x;
  for (int i = 1; i <= n - x + 1; i++) {
    if (canput(i, i + x - 1)) {
      cout << ++cnt << endl;
      l[cnt] = i, r[cnt] = i + x - 1;
      for (int j = l[cnt]; j <= r[cnt]; j++) a[j] = 1;
      al[cnt] = 1;
      return;
    }
  }
  printf("NULL\n");
  return;
}
void erase() {
  cin >> x;
  if (x > cnt || x < 1 || !al[x]) {
    printf("ILLEGAL_ERASE_ARGUMENT\n");
    return;
  }
  for (int j = l[x]; j <= r[x]; j++) a[j] = 0;
  l[x] = r[x] = 0;
  al[x] = 0;
  return;
}
void deflagment() {
  for (int i = 1; i <= cnt; i++) {
    if (al[i]) {
      for (int j = l[i]; j <= r[i]; j++) a[j] = 0;
      while (a[l[i] - 1] == 0 && l[i] > 1) {
        l[i]--;
        r[i]--;
      }
      for (int j = l[i]; j <= r[i]; j++) a[j] = 1;
    }
  }
  return;
}
int main() {
  cin >> t >> n;
  for (int i = 1; i <= t; i++) {
    string s;
    cin >> s;
    if (s[0] == 'a') alloc();
    if (s[0] == 'e') erase();
    if (s[0] == 'd') deflagment();
  }
  return 0;
}
