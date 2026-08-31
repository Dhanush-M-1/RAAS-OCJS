#include <bits/stdc++.h>
using namespace std;
int n, cnt[100009];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (int i = 1; i < n; i++) {
    int x, y;
    cin >> x >> y;
    cnt[x]++, cnt[y]++;
  }
  for (int i = 1; i <= n; i++)
    if (cnt[i] == 2) return cout << "NO", 0;
  cout << "YES";
}
