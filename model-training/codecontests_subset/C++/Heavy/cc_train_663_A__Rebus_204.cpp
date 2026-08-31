#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int a[110], b[110];
int main() {
  char c;
  int n;
  v.push_back(1);
  while (cin >> c) {
    cin >> c;
    if (c == '+') v.push_back(1);
    if (c == '-') v.push_back(-1);
    if (c == '=') {
      cin >> n;
      break;
    }
  }
  int cnt1 = 0, cnt2 = 0;
  for (int i = 0; i < v.size(); ++i)
    if (v[i] == 1)
      cnt1++;
    else
      cnt2++;
  int maxn = cnt1 * n - cnt2;
  int minv = max(0, cnt1 - cnt2 * n);
  if (maxn < n || n < minv) {
    cout << "Impossible" << endl;
    return 0;
  } else {
    for (int i = 1; i <= cnt1; ++i) a[i] = n;
    for (int i = 1; i <= cnt2; ++i) b[i] = 1;
    int cur = maxn;
    for (int i = 1; i <= cnt1; ++i) {
      if (cur - n <= n - 1) {
        a[i] -= (cur - n);
        cur = n;
      } else {
        a[i] -= (n - 1);
        cur -= (n - 1);
      }
      if (cur == n) break;
    }
    if (cur != n) {
      for (int i = 1; i <= cnt2; ++i) {
        if (cur - n <= n - 1) {
          b[i] += (cur - n);
          cur = n;
        } else {
          b[i] += (n - 1);
          cur -= (n - 1);
        }
        if (cur == n) break;
      }
    }
    int p = 2, q = 1;
    cout << "Possible" << endl;
    cout << a[1];
    for (int i = 1; i < v.size(); ++i) {
      if (v[i] == 1)
        cout << " + " << a[p++];
      else
        cout << " - " << b[q++];
    }
    cout << " = " << n << endl;
  }
}
