#include <bits/stdc++.h>
using namespace std;
long long b[100005], c[100005], d[100005];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long a;
  cin >> a;
  for (int i = 0; i <= a - 1; i++) {
    cin >> b[i];
  }
  sort(b, b + a);
  for (int i = 0; i <= a - 2; i++) {
    cin >> c[i];
  }
  sort(c, c - 1 + a);
  for (int i = 0; i <= a - 1; i++) {
    if (b[i] != c[i]) {
      cout << b[i] << endl;
      break;
    }
  }
  for (int i = 0; i <= a - 3; i++) {
    cin >> d[i];
  }
  sort(d, d + a - 2);
  for (int i = 0; i <= a - 2; i++) {
    if (c[i] != d[i]) {
      cout << c[i] << endl;
      break;
    }
  }
}
