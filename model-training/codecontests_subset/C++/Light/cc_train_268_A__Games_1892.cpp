#include <bits/stdc++.h>
using namespace std;
int fr[101][2];
int main() {
  int n, c = 0;
  cin >> n;
  int ind = 1;
  map<int, int> mp;
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a >> b;
    if (mp[a] == 0) mp[a] = ind++;
    if (mp[b] == 0) mp[b] = ind++;
    fr[mp[a]][0]++;
    fr[mp[b]][1]++;
  }
  for (int i = 1; i < ind; i++) c += fr[i][0] * fr[i][1];
  cout << c << endl;
  return 0;
}
