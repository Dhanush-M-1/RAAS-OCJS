#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int p = 1, s = 0;
int sign[1000], ans[1000];
int ev(int i) { return sign[i] ? ans[i] : -ans[i]; }
int main() {
  int cnt = 0;
  char c;
  int i = 1;
  sign[0] = 1;
  int sm = 0;
  while (1) {
    cin >> c;
    cin >> c;
    ans[cnt++] = 1;
    sm += ev(cnt - 1);
    if (c == '=') break;
    p += (c == '+');
    s += (c == '-');
    sign[i++] = (c == '+');
  }
  int n;
  cin >> n;
  cerr << sm << endl;
  for (int j = 0; j < int(cnt); ++j) {
    if (sm > n && !sign[j]) {
      ans[j] += min(n - 1, sm - n);
      sm -= ans[j] - 1;
      cerr << ans[j] << endl;
    }
    if (sm < n && sign[j]) {
      ans[j] += min(n - 1, n - sm);
      sm += ans[j] - 1;
    }
    cerr << j << ", sm = " << sm << endl;
  }
  if (sm == n) {
    cout << "Possible\n";
  } else {
    cout << "Impossible\n";
    return 0;
  }
  for (int i = 0; i < int(cnt); ++i) {
    cout << ans[i];
    if (i == cnt - 1)
      cout << " = ";
    else if (sign[i + 1])
      cout << " + ";
    else
      cout << " - ";
  }
  cout << n << endl;
  return 0;
}
