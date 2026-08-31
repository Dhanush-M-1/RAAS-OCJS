#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > a(100005);
int main() {
  int ans = 1, n;
  scanf("%d", &(n));
  for (int i = (1); i <= (n); i++) {
    int v, h;
    scanf("%d", &(v));
    scanf("%d", &(h));
    pair<int, int> x;
    x.first = v;
    x.second = h;
    a[i] = x;
  }
  int last = a[1].first;
  for (int i = (2); i <= (n - 1); i++) {
    int c = a[i].first;
    int h = a[i].second;
    if (c - h > last)
      ans++, last = c;
    else {
      if (a[i + 1].first > c + h)
        ans++, last = c + h;
      else
        last = c;
    }
  }
  if (n > 1) ans++;
  cout << ans << endl;
  return 0;
}
