#include <bits/stdc++.h>
using namespace std;
int a[int(1e5 + 5)], i, m, ans, k, l, j, q, x, n, ma, mi, v, g;
string s, s1, in;
vector<int> pl, mn;
void pr() {
  int P = 1, M = 0;
  cout << pl[0] << " ";
  for (int i = 1; i < k; i++) {
    if (a[i] == 1) {
      cout << "+ " << pl[P++] << " ";
    } else if (a[i] == -1) {
      cout << "- " << mn[M++] << " ";
    }
  }
  cout << "= " << n << endl;
}
int main() {
  getline(cin, s);
  v++;
  a[k++] = 1;
  for (int i = 2; i < s.size(); i += 4) {
    if (s[i] == '=') {
      i++;
      i++;
      while (i < s.size()) n = n * 10 + s[i] - '0', i++;
      break;
    }
    if (s[i] == '-')
      a[k++] = -1, g++;
    else
      a[k++] = 1, v++;
  }
  if (n * v - g < n || v - n * g > n) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  int N = n - v + g;
  if (N < 0) {
    N *= -1;
    for (int i = 0; i < g; i++) {
      mn.push_back(1 + min(N, n - 1));
      N -= min(N, n - 1);
    }
    for (int i = 0; i < v; i++) {
      pl.push_back(1);
    }
  } else {
    for (int i = 0; i < g; i++) mn.push_back(1);
    for (int i = 0; i < v; i++) {
      pl.push_back(1 + min(N, n - 1));
      N -= min(N, n - 1);
    }
  }
  pr();
}
