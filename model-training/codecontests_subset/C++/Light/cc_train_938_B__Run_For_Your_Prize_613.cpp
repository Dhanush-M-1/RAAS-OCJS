#include <bits/stdc++.h>
using namespace std;
const int INF = 1e6;
int n, a, b;
int main() {
  ios::sync_with_stdio(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int in;
    cin >> in;
    if (in - 1 < INF - in)
      a = max(a, in - 1);
    else
      b = max(b, INF - in);
  }
  cout << max(a, b) << endl;
  return 0;
}
