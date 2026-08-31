#include <bits/stdc++.h>
using namespace std;
long long bz = -10000000000;
long long t[50001], ll[50001], rr[50001], dd[50001];
long long tu[50001];
int main() {
  long long n, m;
  cin >> n >> m;
  for (long long a = 1; a <= n; a++) tu[a] = bz;
  for (long long a = 1; a <= m; a++) cin >> t[a] >> ll[a] >> rr[a] >> dd[a];
  for (long long a = 1; a <= m; a++) {
    if (t[a] == 1) {
      for (long long b = ll[a]; b <= rr[a]; b++) {
        if (tu[b] == bz)
          continue;
        else
          tu[b] += dd[a];
      }
    } else {
      long long jc = 1;
      for (long long b = ll[a]; b <= rr[a]; b++) {
        if (tu[b] == bz) {
          tu[b] = dd[a];
          jc = 0;
        } else {
          if (tu[b] >= dd[a]) {
            tu[b] = dd[a];
            jc = 0;
          }
        }
      }
      if (jc) {
        cout << "NO";
        return 0;
      }
    }
  }
  for (long long a = 1; a <= n; a++)
    if (tu[a] == bz) tu[a] = 0;
  for (long long a = m; a >= 1; a--) {
    if (t[a] == 2) {
      long long jc = 1;
      for (long long b = ll[a]; b <= rr[a]; b++) {
        if (tu[b] == dd[a]) jc = 0;
      }
      if (jc) {
        cout << "NO";
        return 0;
      }
      continue;
    }
    for (long long b = ll[a]; b <= rr[a]; b++)
      if (tu[a] != bz) tu[b] -= dd[a];
  }
  cout << "YES" << endl;
  long long jc = 0;
  for (long long a = 1; a <= n; a++) {
    if (tu[a] == bz) tu[a] = 0;
    if (!jc) {
      cout << tu[a];
      jc = 1;
    } else {
      cout << " " << tu[a];
    }
  }
}
