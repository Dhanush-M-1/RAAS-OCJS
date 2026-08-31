#include <bits/stdc++.h>
using namespace std;
const int M = 1e5 + 10;
int n, cnt[M];
string s;
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; i++) cnt[s[i]]++;
  cout << min(cnt['8'], n / 11) << endl;
  return 0;
}
