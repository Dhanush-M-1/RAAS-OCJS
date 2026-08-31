#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<string> graph(n);
    for (auto &i : graph) cin >> i;
    int a = graph[0][1], b = graph[1][0], c = graph[n - 2][n - 1],
        d = graph[n - 1][n - 2];
    if (a == b and b == c and c == d)
      cout << "2\n1 2\n2 1\n";
    else if (a == b and c == d)
      cout << "0\n";
    else if (a != b and c == d) {
      if (a == c)
        cout << "1\n1 2\n";
      else
        cout << "1\n2 1\n";
    } else if (a == b and c != d) {
      if (a == c)
        cout << "1\n" << n - 1 << " " << n << endl;
      else
        cout << "1\n" << n << " " << n - 1 << endl;
    } else {
      if (a == c)
        cout << "2\n1 2\n" << n << " " << n - 1 << endl;
      else
        cout << "2\n1 2\n" << n - 1 << " " << n << endl;
    }
  }
  return 0;
}
