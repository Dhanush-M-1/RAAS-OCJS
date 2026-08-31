#include <bits/stdc++.h>
using namespace std;
struct T1 {
  int fr, len;
  int nu;
  int vis;
  T1(){};
  T1(int fr, int len, int nu) : fr(fr), len(len), nu(nu){};
};
bool operator<(const T1& a, const T1& b) { return a.fr < b.fr; }
vector<T1> a;
int used[2000];
int m, nu;
int find(int x) {
  for (int i = 0; i < a.size(); i++) {
    if (a[i].nu == x) return i;
  }
  return -1;
}
int call(int x) {
  int i, j, k;
  for (i = 1; i <= m;)
    if (used[i] == 0) {
      k = 0;
      for (j = i + 1; j <= m; j++)
        if (used[j]) break;
      k = j - i;
      if (k >= x) {
        a.push_back(T1(i, x, nu));
        for (int z = i; z < i + x; z++) used[z] = 1;
        nu++;
        return 1;
      }
      i = j;
    } else
      i++;
  return 0;
}
int clear(int x) {
  int cp = find(x);
  if (cp == -1) return 0;
  for (int i = 0; i < a[cp].len; i++) used[a[cp].fr + i] = 0;
  a.erase(a.begin() + cp);
  return 1;
}
void resize() {
  sort(a.begin(), a.end());
  int sum = 0;
  for (int i = 0; i < a.size(); i++) sum += a[i].len;
  for (int i = 1; i <= sum; i++) {
    used[i] = 1;
  }
  for (int i = sum + 1; i <= m; i++) used[i] = 0;
  sum = 1;
  for (int i = 0; i < a.size(); i++) {
    a[i].fr = sum;
    sum += a[i].len;
  }
}
int main() {
  int T, x;
  string s;
  cin >> T >> m;
  a.clear();
  memset(used, 0, sizeof(used));
  nu = 1;
  for (int i = 0; i < T; i++) {
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      if (call(x) == 1)
        cout << nu - 1 << endl;
      else
        cout << "NULL" << endl;
    } else if (s == "erase") {
      cin >> x;
      if (clear(x) == 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else
      resize();
  }
  return 0;
}
