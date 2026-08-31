#include <bits/stdc++.h>
using namespace std;
bool debug = false;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
long long ln, lk, lm;
int main() {
  string s;
  cin >> s;
  vector<int> v;
  for (int i = 0; i < s.size(); i++)
    if (s[i] != '+') {
      v.push_back(s[i] - '0');
    }
  sort(v.begin(), v.end());
  for (int(i) = 0; (i) < (int)(v.size()); (i)++) {
    printf("%d", v[i]);
    if (i != v.size() - 1) printf("+");
  }
  return 0;
}
