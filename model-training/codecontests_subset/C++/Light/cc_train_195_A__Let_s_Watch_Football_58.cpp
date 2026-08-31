#include <bits/stdc++.h>
using namespace std;
const int MAX = 10001;
void solve() {}
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    int t = a * c;
    for (int i = 0; i <= 1005 * 1005; i++) {
      if (b * i + c * b >= a * c) {
        cout << i << endl;
        break;
      }
    }
  }
  fclose(stdin);
  fclose(stdout);
  return 0;
}
