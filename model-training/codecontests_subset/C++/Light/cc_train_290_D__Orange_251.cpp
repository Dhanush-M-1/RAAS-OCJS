#include <bits/stdc++.h>
using namespace std;
const int INF = 1000000009;
const int MAXN = 1010;
const int MAXM = 1010;
int main() {
  string a;
  cin >> a;
  int b;
  cin >> b;
  for (int i = 0; i < a.size(); ++i) {
    if (a[i] >= 'a') a[i] = a[i] - 32;
    if ('A' <= a[i] && a[i] < 'A' + b) {
    } else {
      a[i] = a[i] + 32;
    }
  }
  cout << a << endl;
  return 0;
}
