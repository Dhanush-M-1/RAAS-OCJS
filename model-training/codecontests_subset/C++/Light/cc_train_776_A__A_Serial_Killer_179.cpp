#include <bits/stdc++.h>
using namespace std;
const long long LINF = (long long)1e18;
const int INF = (int)1e9 + 7;
const int N = (int)1e5 + 1;
const double PI = 3.14159265359;
bool u[N + 5];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  string f, s;
  f = s1;
  s = s2;
  cout << s1 << " " << s2 << endl;
  for (int i = 1; i <= n; ++i) {
    string s3, s4;
    cin >> s3 >> s4;
    if (s3 == s1) {
      cout << s4 << " " << s2 << endl;
      s1 = s4;
    } else if (s3 == s2) {
      cout << s4 << " " << s1 << endl;
      s2 = s4;
    }
  }
  return 0;
}
