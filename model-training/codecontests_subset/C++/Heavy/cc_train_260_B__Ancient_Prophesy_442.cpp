#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const int INF = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
int days[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
struct Node {
  int d, m, y;
  bool operator<(const Node &rhs) const {
    return d < rhs.d ||
           (d == rhs.d && (m < rhs.m || (m == rhs.m && y < rhs.y)));
  }
};
map<Node, int> cnt;
char s[N];
int n;
void check2(int i) {
  if (i + 9 >= n) return;
  if (!isdigit(s[i])) return;
  if (!isdigit(s[i + 1])) return;
  if (!isdigit(s[i + 3])) return;
  if (!isdigit(s[i + 4])) return;
  if (!isdigit(s[i + 6])) return;
  if (!isdigit(s[i + 7])) return;
  if (!isdigit(s[i + 8])) return;
  if (!isdigit(s[i + 9])) return;
  if (s[i + 2] != '-' || s[i + 5] != '-') return;
  int d = s[i] - '0';
  d = d * 10 + (s[i + 1] - '0');
  int m = s[i + 3] - '0';
  m = m * 10 + (s[i + 4] - '0');
  int y = s[i + 6] - '0';
  y = y * 10 + (s[i + 7] - '0');
  y = y * 10 + (s[i + 8] - '0');
  y = y * 10 + (s[i + 9] - '0');
  if (d < 1 || d > 31) return;
  if (m < 1 || m > 12) return;
  if (d > days[m]) return;
  if (y < 2013 || y > 2015) return;
}
void check(int i) {
  int d = 0, m = 0, y = 0;
  if (i + 2 >= n || s[i + 1] == '-' || s[i + 2] != '-') return;
  d = s[i++] - '0';
  d = d * 10 + (s[i++] - '0');
  if (i + 1 >= n || s[i + 1] == '-') return;
  i++;
  if (i + 2 >= n || s[i + 1] == '-' || s[i + 2] != '-') return;
  m = s[i++] - '0';
  m = m * 10 + (s[i++] - '0');
  if (i + 1 >= n || s[i + 1] == '-') return;
  i++;
  if (i + 3 >= n || s[i + 1] == '-' || s[i + 2] == '-' || s[i + 3] == '-')
    return;
  y = s[i++] - '0';
  y = y * 10 + (s[i++] - '0');
  y = y * 10 + (s[i++] - '0');
  y = y * 10 + (s[i++] - '0');
  if (d < 1 || d > 31) return;
  if (m < 1 || m > 12) return;
  if (d > days[m]) return;
  if (y < 2013 || y > 2015) return;
  cnt[Node{d, m, y}]++;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> s;
  n = strlen(s);
  for (int i = 0; i < n; ++i) {
    if (s[i] != '-') check(i);
  }
  Node ans = {0, 0, 0};
  int mx = 0;
  for (auto p : cnt) {
    if (p.second > mx) {
      mx = p.second;
      ans = p.first;
    }
  }
  if (ans.d < 10) cout << 0;
  cout << ans.d;
  cout << "-";
  if (ans.m < 10) cout << 0;
  cout << ans.m;
  cout << "-";
  cout << ans.y << '\n';
  return 0;
}
