#include <bits/stdc++.h>
using namespace std;
bool byte[105];
int sum, ans, clear[105], start[105];
vector<int> use;
int main() {
  int t, n;
  cin >> t >> n;
  sum = n;
  for (int i = 1; i <= n; i++) byte[i] = true;
  while (t--) {
    string in;
    int a;
    cin >> in;
    if (in == "defragment") {
      for (int i = 1; i <= n; i++)
        if (i > n - sum)
          byte[i] = true;
        else
          byte[i] = false;
      pair<int, int> order[105];
      int cnt = 1;
      for (int i = 0; i < use.size(); i++)
        if (start[use[i]]) order[cnt++] = make_pair(start[use[i]], use[i]);
      sort(order + 1, order + cnt);
      int k = 1;
      for (int i = 1; i < cnt; i++) {
        if (!clear[order[i].second]) continue;
        start[order[i].second] = k;
        k += clear[order[i].second];
      }
    } else if (in == "alloc") {
      cin >> a;
      bool find = false;
      for (int i = 1; i <= n - a + 1 && !find; i++) {
        bool ok = true;
        for (int j = i; j <= i + a - 1 && !find; j++)
          if (!byte[j]) ok = false;
        if (ok) {
          find = true;
          start[++ans] = i;
          clear[ans] = a;
          use.push_back(ans);
          sum -= a;
          cout << ans << endl;
        }
      }
      if (find)
        for (int i = start[ans]; i <= start[ans] + clear[ans] - 1; i++)
          byte[i] = false;
      else
        cout << "NULL" << endl;
    } else {
      cin >> a;
      if (a <= 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      }
      if (!clear[a])
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        sum += clear[a];
        for (int i = start[a]; i <= start[a] + clear[a] - 1; i++)
          byte[i] = true;
        clear[a] = start[a] = 0;
      }
    }
  }
  return 0;
}
