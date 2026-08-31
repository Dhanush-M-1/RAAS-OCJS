#include <bits/stdc++.h>
using namespace std;
long long int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o,
    p = 0, q = 0, r, s, t, u, v, w, x, y, z, temp = 0, ans = 0, t1, t2, sum = 0;
vector<long long int> v1, v2, v3, v4, v5, v6;
vector<string> vs1, vs2, vs3, vs4;
double f1, f2 = 0, f3, f4;
vector<double> v10;
vector<pair<long long int, long long int>> v11, v12, v13, v14;
string s1, s2, s3, s4, s5, s6;
long long int a10[100][3];
long long int a1[100000], a2[100000];
char c1, c2, c3;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> s1;
  s2 = s1;
  sort(s2.begin(), s2.end());
  if (s2 == s1) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  j = n - 1;
  s2 = s1;
  reverse(s2.begin(), s2.end());
  if (s1 == s2) {
    for (i = 0; i < n; i++) {
      if (s1[i] > s1[j]) {
        cout << i + 1 << " " << j + 1;
        return 0;
      }
    }
  } else {
    for (i = 0; i < n - 1; i++) {
      if (s1[i] > s1[i + 1]) {
        cout << i + 1 << " " << i + 2;
        return 0;
      }
    }
  }
  return 0;
}
