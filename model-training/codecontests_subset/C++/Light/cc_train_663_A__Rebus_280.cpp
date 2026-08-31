#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  vector<char> s;
  int p = 1, m = 0;
  s.push_back('+');
  for (int i = 0;; ++i) {
    char c;
    cin >> c >> c;
    s.push_back(c);
    if (c == '=') break;
    if (c == '+')
      ++p;
    else
      ++m;
  }
  s.pop_back();
  cin >> n;
  if (p * n - m >= n && n >= p - m * n)
    cout << "Possible" << endl;
  else {
    cout << "Impossible" << endl;
    return 0;
  }
  int k = (int)(s).size();
  vector<int> a(k);
  for (int i = 0; i < k; ++i) a[i] = 1;
  if (p - m >= n) {
    int t = p - m - n;
    for (int i = 0; i < k; ++i) {
      if (s[i] == '-') {
        a[i] += min(t, n - 1);
        t -= min(t, n - 1);
      }
    }
  } else {
    int t = n - p + m;
    for (int i = 0; i < k; ++i) {
      if (s[i] == '+') {
        a[i] += min(t, n - 1);
        t -= min(t, n - 1);
      }
    }
  }
  cout << a[0] << " ";
  for (int i = 1; i < k; ++i) cout << s[i] << " " << a[i] << " ";
  cout << "= " << n << endl;
  return 0;
}
