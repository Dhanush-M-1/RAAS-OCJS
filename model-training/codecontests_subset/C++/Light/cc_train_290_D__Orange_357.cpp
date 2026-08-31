#include <bits/stdc++.h>
using namespace std;
const int MaxN = 200005;
const double eps = 1e-7;
const double DINF = 1e100;
const int INF = 1000000006;
const long long LINF = 1000000000000000005ll;
string s;
int main() {
  cin >> s;
  int m;
  cin >> m;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] - 'A' + 'a';
  }
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] < m + 'a') s[i] = s[i] - 'a' + 'A';
  }
  cout << s << endl;
  return 0;
}
