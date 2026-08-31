#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, f, g, h;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      h = i * j;
      string s;
      while (h > 0) {
        s += (char)(h % n + 48);
        h /= n;
      }
      reverse(s.begin(), s.end());
      cout << s << " ";
    }
    cout << endl;
  }
}
