#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:60777216")
using namespace std;
int main() {
  string s;
  vector<int> v;
  bool plus = true;
  while (cin >> s) {
    if (s == "=") {
      break;
    }
    if (s == "-") plus = false;
    if (s == "+") plus = true;
    if (s == "?") v.push_back(plus ? 1 : -1);
  }
  int n;
  cin >> n;
  int np = 0;
  int nm = 0;
  for (int i = (0); i < (v.size()); i++)
    if (v[i] == 1)
      np++;
    else
      nm++;
  int from = np;
  int to = np * n;
  from -= nm * n;
  to -= nm;
  if (from <= n && n <= to) {
    puts("Possible");
    int sum = 0;
    for (int i = (0); i < (v.size()); i++) {
      if (v[i] > 0)
        np--;
      else
        nm--;
      if (i) printf(" %c ", v[i] == 1 ? '+' : '-');
      for (int j = 1; j <= n; j++) {
        from = sum + v[i] * j + np;
        to = sum + v[i] * j + np * n;
        from -= nm * n;
        to -= nm;
        if (from <= n && n <= to) {
          cout << j;
          sum += j * v[i];
          break;
        }
      }
    }
    cout << " = " << n << endl;
  } else {
    puts("Impossible");
  }
  return 0;
}
