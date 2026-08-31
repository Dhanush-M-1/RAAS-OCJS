#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
const int inf = 1000 * 1000 * 1000;
const int mod = 998244353;
mt19937 myrand(chrono::steady_clock::now().time_since_epoch().count());
int t;
int n;
long long l, r;
int main() {
  cin >> t;
  while (t--) {
    scanf("%d%lld%lld", &n, &l, &r);
    vector<pair<long long, long long> > mas;
    vector<int> start;
    long long st = 1;
    for (int i = n - 1; i >= 1; i--) {
      mas.push_back(make_pair(st, st + 2 * i - 1));
      start.push_back(n - i);
      st += 2 * i;
    }
    mas.push_back(make_pair(st, st));
    for (int i = 0; i < (int)mas.size(); i++) {
      if (l > mas[i].second) continue;
      if (r < mas[i].first) continue;
      if (i == (int)mas.size() - 1) {
        printf("1");
        continue;
      }
      int ll = max(l, mas[i].first) - mas[i].first + 1;
      int rr = min(r, mas[i].second) - mas[i].first + 1;
      int s = start[i];
      for (int j = ll; j <= rr; j++) {
        if (j % 2) {
          printf("%d ", s);
        } else {
          printf("%d ", s + j / 2);
        }
      }
    }
    printf("\n");
  }
  return 0;
}
