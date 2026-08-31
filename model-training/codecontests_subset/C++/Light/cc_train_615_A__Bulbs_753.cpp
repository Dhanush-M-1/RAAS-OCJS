#include <bits/stdc++.h>
int mm[110];
using namespace std;
int main(int argc, char *argv[]) {
  int t = 1;
  for (int z = 1; z < t + 1; z++) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      for (int j = 0; j < x; j++) {
        int y;
        cin >> y;
        mm[y] = 1;
      }
    }
    bool ff = true;
    for (int i = 1; i <= m; i++)
      if (mm[i] != 1) ff = false;
    if (ff)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
