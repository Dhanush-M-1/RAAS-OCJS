#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int N = 300005;
const int MOD = 1e9 + 7;
char s[N];
int main() {
  int n;
  cin >> n >> s + 1;
  for (int i = 2; i <= (n); ++i) {
    if (s[i] < s[i - 1]) {
      puts("YES");
      cout << i - 1 << " " << i << endl;
      return 0;
    }
  }
  puts("NO");
  return 0;
}
