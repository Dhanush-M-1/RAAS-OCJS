#include <bits/stdc++.h>
using namespace std;
const int maxi = 1e6 + 10;
int a[maxi];
string s;
int n;
int cnt[maxi];
int main() {
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; i++) cnt[s[i] - '0']++;
  int mm = n / 11;
  mm = min(mm, cnt[8]);
  cout << mm << endl;
  return 0;
}
