#include <bits/stdc++.h>
using namespace std;
long long int P[20], out[6], ans[20];
vector<int> vec[10];
vector<pair<int, pair<int, int> > > num;
void print(int sz) {
  memset(out, 0, sizeof out);
  for (int i = 0; i < sz; i++) {
    for (int j = 0; j < num[ans[i]].second.first; j++) out[j] += 7 * P[i];
    for (int j = 0; j < num[ans[i]].second.second; j++)
      out[j + num[ans[i]].second.first] += 4 * P[i];
  }
  for (int i = 0; i < 6; i++) cout << out[i] << ' ';
  cout << '\n';
  return;
}
bool build(long long int rem, int pos = 0) {
  if (rem == 0) {
    print(pos);
    return true;
  }
  int id = rem % 10;
  for (auto valid : vec[id]) {
    int val = num[valid].first;
    if (val > rem) continue;
    ans[pos] = valid;
    if (build((rem - val) / 10, pos + 1)) return true;
  }
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  P[0] = 1;
  for (int i = 1; i <= 18; i++) P[i] = P[i - 1] * 10;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++) {
      vec[(7 * i + 4 * j) % 10].push_back(((int)(num).size()));
      num.push_back(make_pair(7 * i + 4 * j, make_pair(i, j)));
    }
  int q;
  cin >> q;
  while (q--) {
    long long int val;
    cin >> val;
    if (!build(val)) cout << "-1\n";
  }
  return 0;
}
