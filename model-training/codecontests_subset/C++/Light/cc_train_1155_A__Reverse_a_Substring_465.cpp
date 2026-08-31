#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 200;
const long long MOD = 1e9 + 7;
long long n, pos, v[N];
string s;
char c;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    v[s[i]] = i;
  }
  for (int i = 0; i < s.size(); i++) {
    for (int j = 'a'; j < s[i]; j++)
      if (v[j] > i) {
        cout << "YES"
             << "\n"
             << i + 1 << " " << v[j] + 1;
        return 0;
      }
  }
  cout << "NO";
  return 0;
}
