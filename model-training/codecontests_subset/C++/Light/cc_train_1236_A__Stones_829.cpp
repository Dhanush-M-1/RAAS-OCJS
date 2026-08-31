#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int stones = 0;
    while (b > 0 && c >= 2) {
      b--;
      c -= 2;
      stones += 3;
    }
    while (a > 0 && b >= 2) {
      a--;
      b -= 2;
      stones += 3;
    }
    cout << stones << endl;
  }
  return 0;
}
