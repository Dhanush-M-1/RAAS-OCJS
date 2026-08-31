#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long INFLL = 0x3f3f3f3f3f3f3f3fLL;
inline long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
const int maxn = 1e5 + 10;
string s1, s2, s3, s4;
string ans1[1005], ans2[1005];
int main() {
  cin >> s1 >> s2;
  int n = read();
  ans1[0] = s1, ans2[0] = s2;
  for (int i = 1; i <= n; i++) {
    cin >> s3 >> s4;
    if (s3 == ans1[i - 1]) {
      ans1[i] = ans2[i - 1];
      ans2[i] = s4;
    } else {
      ans1[i] = ans1[i - 1];
      ans2[i] = s4;
    }
  }
  for (int i = 0; i <= n; i++) cout << ans1[i] << " " << ans2[i] << endl;
  return 0;
}
