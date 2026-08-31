#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const int inf = (int)1e9;
const double inf1 = 1e-9;
const int ss = (int)1e6 + 3;
const int base = inf;
bool pred(const pair<string, int>& i, const pair<string, int>& j) {
  if (i.second == j.second)
    return i.first < j.first;
  else
    return i.second > j.second;
}
bool pred2(const int& i, const int& j) { return i < j; }
int main() {
  int n;
  scanf("%d", &n);
  --n;
  int k = n + 1;
  int z;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      z = (i + 1) * (j + 1);
      string s = "";
      while (z != 0) {
        s = (char)(z % k + '0') + s;
        z /= k;
      }
      cout << s << " ";
    }
    cout << endl;
  }
  return 0;
}
