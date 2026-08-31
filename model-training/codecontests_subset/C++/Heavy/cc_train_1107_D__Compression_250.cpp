#include <bits/stdc++.h>
using namespace std;
int a[5300][5300];
int n;
bool g(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      int t = a[i][j];
      for (int p = i; p <= i + x - 1; p++) {
        for (int q = j; q <= j + x - 1; q++) {
          if (a[p][q] != t) return false;
        }
      }
    }
  }
  return true;
}
int f(int st, int end, vector<int>& v) {
  if (st > end) return -1;
  int mid = (st + end) / 2;
  bool x = g(v[mid]);
  if (x) {
    int rans = f(mid + 1, end, v);
    if (rans != -1) return rans;
    return mid;
  }
  return f(st, mid - 1, v);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    string s;
    cin >> s;
    int l = 1;
    for (int j = 0; j < s.size(); j++) {
      int x = s[j];
      int z;
      if (x >= 48 && x <= 57) {
        z = s[j] - 48;
      } else {
        z = (s[j] - 65) + 10;
      }
      vector<int> v(4);
      for (int k = 0; k < 4; k++) {
        if ((z & 1) == 1) {
          v.push_back(1);
        } else
          v.push_back(0);
        z = z >> 1;
      }
      reverse(v.begin(), v.end());
      for (int k = 0; k < 4; k++) a[i][l++] = v[k];
    }
  }
  vector<int> v;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      v.push_back(i);
      if (i * i != n) v.push_back(n / i);
    }
  }
  sort(v.begin(), v.end());
  reverse(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
    if (g(v[i])) {
      cout << v[i];
      return 0;
    }
  }
}
