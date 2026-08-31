#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base ::sync_with_stdio(false);
  int n, s, k = 0, l = 0, j, tot;
  cin >> n;
  j = n;
  while (n--) {
    cin >> s;
    s == 200 ? k++ : l++;
  }
  tot = k * 2 + l;
  if (tot & 1 || l & 1 || (!l && k & 1) || j == 1) {
    cout << "NO\n";
  } else
    cout << "YES\n";
  return 0;
}
