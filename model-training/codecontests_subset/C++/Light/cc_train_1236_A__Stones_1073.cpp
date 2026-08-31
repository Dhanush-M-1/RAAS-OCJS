#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    int count = 0;
    int mn = min(b, c / 2);
    count += (mn * 3);
    b -= mn;
    c -= (2 * mn);
    mn = min(a, b / 2);
    count += (mn * 3);
    cout << count << endl;
  }
}
