#include <bits/stdc++.h>
using namespace std;
int id = 0;
int m[104];
string cmd;
bool alloc(int n, int p) {
  int s = -1, e;
  for (e = 0; e <= n; ++e) {
    if (0 == m[e] && -1 == s) s = e;
    if (-1 != s && 0 != m[e]) {
      if (e - s < p) s = -1;
    }
  }
  if (-1 != s) {
    ++id;
    while (p--) m[s++] = id;
    return true;
  } else
    return false;
}
bool erase(int n, string r) {
  int i, e = 0, p = 0;
  for (i = 0; i < r.length(); ++i) p *= 10, p += r[i] - '0';
  for (i = 0; i < n; ++i)
    if (p == m[i]) m[i] = 0, ++e;
  if (0 == e || 0 == p)
    return false;
  else
    return true;
}
void defragment(int n) {
  int z, i, nz;
  for (z = 0; z < n; ++z)
    if (0 == m[z]) break;
  for (nz = z; nz < n; ++nz) {
    if (0 != m[nz]) {
      m[z++] = m[nz];
      m[nz] = 0;
    }
  }
}
int main() {
  int t, n, p;
  cin >> t >> n;
  m[n] = -1;
  for (int i = 0; i < t; ++i) {
    cin >> cmd;
    if ("alloc" == cmd) {
      cin >> p;
      if (alloc(n, p))
        cout << id << endl;
      else
        cout << "NULL" << endl;
    } else if ("erase" == cmd) {
      string e;
      cin >> e;
      if (e.length() > 4 || !erase(n, e))
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      defragment(n);
    }
  }
  return 0;
}
