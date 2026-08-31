#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const int dx4[] = {-1, 0, 1, 0};
const int dy4[] = {0, 1, 0, -1};
const int dx8[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const int dy8[] = {-1, 0, 1, -1, 1, -1, 0, 1};
const int dxk[] = {-2, -2, -1, -1, 1, 1, 2, 2};
const int dyk[] = {-1, 1, -2, 2, -2, 2, -1, 1};
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n;
  string s;
  cin >> n >> s;
  string tmp = s;
  sort(s.begin(), s.end());
  if (s == tmp) {
    cout << "NO\n";
  } else {
    cout << "YES\n";
    for (int i = 0; i < n; i++) {
      if (s[i] != tmp[i]) {
        for (int j = i; j < n; j++) {
          if (tmp[j] == s[i]) {
            cout << i + 1 << " " << j + 1 << '\n';
            return 0;
          }
        }
      }
    }
  }
  return 0;
}
