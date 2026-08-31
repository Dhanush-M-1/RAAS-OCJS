#include <bits/stdc++.h>
using namespace std;
inline int ri() {
  int x;
  scanf("%d", &x);
  return x;
}
template <typename T>
inline bool smax(T& a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <typename T>
inline bool smin(T& a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
vector<int> f(int sum, int n) {
  vector<int> v(n);
  for (int i = 0; i < (n); i++) {
    v[i] = sum / n;
    if (i < sum % n) v[i]++;
  }
  return v;
}
int main() {
  string s = "+";
  char c;
  int n;
  while (true) {
    cin >> c;
    if (c != '=') {
      if (c != '?') s += c;
    } else {
      cin >> n;
      break;
    }
  }
  int m = s.length();
  int a = 0, b = 0;
  for (int i = 0; i < (m); i++)
    if (s[i] == '+')
      a++;
    else
      b++;
  if (b * n + n < a || b + n > a * n) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  vector<int> res;
  for (int i = (b); i < (b * n + 1); i++) {
    int j = i + n;
    if (a <= j && j <= a * n) {
      auto va = f(j, a), vb = f(i, b);
      for (int xa = 0, xb = 0, k = 0; k < m; k++) {
        if (s[k] == '+')
          res.push_back(va[xa++]);
        else
          res.push_back(vb[xb++]);
      }
      break;
    }
  }
  for (int i = 0; i < (m); i++) {
    if (i) cout << s[i] << ' ';
    cout << res[i] << ' ';
  }
  cout << "= " << n << endl;
  return 0;
}
