#include <bits/stdc++.h>
using namespace std;
const int N = 2 + 1e5;
const int MAXN = 1 + 5e4;
const int INF = 0x3f3f3f3f;
int n, m;
int d[N];
int main() {
  cin >> n >> m;
  int kq = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    for (int j = 0; j < x; j++) {
      int y;
      cin >> y;
      d[y]++;
      if (d[y] == 1) kq++;
    }
  }
  if (kq == m)
    cout << "YES";
  else
    cout << "NO";
}
