#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 7;
vector<int> arr[N];
bool vis[N];
signed main() {
  string x, y;
  cin >> x >> y;
  cout << x << " " << y << endl;
  int n;
  cin >> n;
  while (n--) {
    string a, b;
    cin >> a >> b;
    if (x == a) {
      x = b;
    } else {
      y = b;
    }
    cout << x << " " << y << endl;
  }
  return 0;
}
