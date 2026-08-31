#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int mass[n];
  for (int i = 0; i < n; i++) cin >> mass[i];
  list<int> lis;
  int ans = 0;
  for (int i = 0; i < m; i++) {
    int temp;
    cin >> temp;
    temp--;
    if (lis.empty())
      lis.push_front(temp);
    else {
      int sum = 0;
      list<int>::iterator i;
      for (i = lis.begin(); i != lis.end(); i++) {
        if (*i == temp)
          break;
        else
          sum += mass[*i];
      }
      if (i != lis.end()) lis.erase(i);
      lis.push_front(temp);
      ans += sum;
    }
  }
  cout << ans << endl;
}
