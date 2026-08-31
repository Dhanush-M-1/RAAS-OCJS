#include <bits/stdc++.h>
using namespace std;
const long long INF = 2000000000000000000LL;
const int inf = 0x3f3f3f3f;
const long double EPS = 1e-9;
long long n, m;
string s;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  map<char, long long> maps;
  int test = 1, tc = 1;
  while (test--) {
    cin >> n >> s;
    for (int i = 0; i < s.size(); i++) maps[s[i]]++;
    if (maps['I'] == 1)
      cout << "1" << endl;
    else if (maps['I'] > 1)
      cout << "0" << endl;
    else
      cout << maps['A'] << endl;
  }
  return 0;
}
