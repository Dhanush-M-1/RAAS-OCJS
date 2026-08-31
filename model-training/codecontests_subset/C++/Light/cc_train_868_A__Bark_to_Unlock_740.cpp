#include <bits/stdc++.h>
using namespace std;
int main() {
  string p, b;
  vector<string> vb;
  int n, matches = 0, res;
  cin >> p >> n;
  for (int i = 0; i < n; i++) {
    cin >> b;
    if (b.compare(p) == 0) matches = 1;
    vb.push_back(b);
  }
  if (matches)
    cout << "YES" << endl;
  else {
    int s = 0;
    res = 0;
    for (int i = 0; i < vb.size(); i++)
      if (vb[i][1] == p[0]) s = 1;
    if (s == 1)
      for (int i = 0; i < vb.size(); i++)
        if (vb[i][0] == p[1]) res = 1;
    if (res)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
