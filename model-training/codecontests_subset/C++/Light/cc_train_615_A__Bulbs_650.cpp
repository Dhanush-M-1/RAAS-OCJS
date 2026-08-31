#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  set<int> BulbsOn;
  int tmp, tmp2;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    for (int j = 0; j < tmp; j++) {
      cin >> tmp2;
      BulbsOn.insert(tmp2);
    }
  }
  if (BulbsOn.size() == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
