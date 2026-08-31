#include <bits/stdc++.h>
using namespace std;
long long n;
string s;
long long cnt[10];
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  cin >> s;
  for (long long(i) = (0); (i) <= (n - 1); (i)++) cnt[s[i] - '0']++;
  cout << min(n / 11, cnt[8]) << endl;
  return 0;
}
