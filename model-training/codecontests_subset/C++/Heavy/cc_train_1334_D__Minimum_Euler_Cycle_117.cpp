#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  srand(time(NULL));
  ;
  long long int p;
  cin >> p;
  while (p--) {
    long long int a, b, c, d, e, l, r, f, cnt = 1;
    vector<long long int> Ans;
    cin >> a >> l >> r;
    f = l;
    long long int fuck = a - 1;
    while (f - (2 * fuck) >= 0 && fuck > 0) {
      f -= (2 * fuck);
      fuck--;
      cnt++;
    }
    if (f == 0) Ans.push_back(a), f++, l++;
    f = (f - 1) / 2;
    f++;
    f += cnt;
    for (c = l; c <= r; c++) {
      if (c % 2 == 1)
        Ans.push_back(cnt);
      else
        Ans.push_back(f), f++;
      if (f == a + 1) cnt++, f = cnt + 1;
    }
    if (r == (a * (a - 1)) + 1) Ans[Ans.size() - 1] = 1;
    for (c = 0; c < Ans.size(); c++) cout << Ans[c] << " ";
    cout << endl;
  }
}
